package com.yermoon.server.helper;

import com.yermoon.server.util.ByteUtils;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.CRC32;

/**
 * @author wangqing
 * @since 14-5-13 ä¸å6:30
 */
public enum HashAlgorithm {

    /**
     * Native hash (String.hashCode()).
     */
    NATIVE_HASH,
    /**
     * CRC32_HASH as used by the perl API. This will be more consistent both
     * across multiple API users as well as java versions, but is mostly likely
     * significantly slower.
     */
    CRC32_HASH,
    /**
     * FNV hashes are designed to be fast while maintaining a low collision
     * rate. The FNV speed allows one to quickly hash lots of data while
     * maintaining a reasonable collision rate.
     * <p/>
     */
    FNV1_64_HASH,
    /**
     * Variation of FNV.
     */
    FNV1A_64_HASH,
    /**
     * 32-bit FNV1.
     */
    FNV1_32_HASH,
    /**
     * 32-bit FNV1a.
     */
    FNV1A_32_HASH,
    /**
     * MD5-based hash algorithm used by ketama.
     */
    KETAMA_HASH,

    /**
     * From mysql source
     */
    MYSQL_HASH,

    ELF_HASH,

    RS_HASH,

    /**
     * From lua source,it is used for long key
     */
    LUA_HASH,
    /**
     * MurMurHashç®æ³ï¼æ¯éå å¯HASHç®æ³ï¼æ§è½å¾é«ï¼
     * æ¯ä¼ ç»çCRC32,MD5ï¼SHA-1ï¼è¿ä¸¤ä¸ªç®æ³é½æ¯å å¯HASHç®æ³ï¼å¤æåº¦æ¬èº«å°±å¾é«ï¼å¸¦æ¥çæ§è½ä¸çæå®³ä¹ä¸å¯é¿åï¼
     * ç­HASHç®æ³è¦å¿«å¾å¤ï¼è¿ä¸ªç®æ³çç¢°æçå¾ä½.
     * http://murmurhash.googlepages.com/
     */
    MurMurHash,
    /**
     * The Jenkins One-at-a-time hash ,please see
     * http://www.burtleburtle.net/bob/hash/doobs.html
     */
    ONE_AT_A_TIME;
    private static final long FNV_64_INIT = 0xcbf29ce484222325L;
    private static final long FNV_64_PRIME = 0x100000001b3L;
    private static final long FNV_32_INIT = 2166136261L;
    private static final long FNV_32_PRIME = 16777619;

    /**
     * Get the md5 of the given key.
     */
    public static byte[] computeMd5(String k) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 not supported", e);
        }
        md5.reset();
        md5.update(ByteUtils.getBytes(k));
        return md5.digest();
    }

    /**
     * Compute the hash for the given key.
     *
     * @return a positive integer hash
     */
    public long hash(final String k) {
        long rv = 0;
        switch (this) {
            case NATIVE_HASH:
                rv = k.hashCode();
                break;
            case CRC32_HASH:
                // return (crc32(shift) >> 16) & 0x7fff;
                CRC32 crc32 = new CRC32();
                crc32.update(ByteUtils.getBytes(k));
                rv = crc32.getValue() >> 16 & 0x7fff;
                break;
            case FNV1_64_HASH: {
                // Thanks to pierre@demartines.com for the pointer
                rv = FNV_64_INIT;
                int len = k.length();
                for (int i = 0; i < len; i++) {
                    rv *= FNV_64_PRIME;
                    rv ^= k.charAt(i);
                }
            }
            break;
            case MurMurHash:
                ByteBuffer buf = ByteBuffer.wrap(k.getBytes());
                int seed = 0x1234ABCD;

                ByteOrder byteOrder = buf.order();
                buf.order(ByteOrder.LITTLE_ENDIAN);

                long m = 0xc6a4a7935bd1e995L;
                int r = 47;

                rv = seed ^ (buf.remaining() * m);

                long ky;
                while (buf.remaining() >= 8) {
                    ky = buf.getLong();

                    ky *= m;
                    ky ^= ky >>> r;
                    ky *= m;

                    rv ^= ky;
                    rv *= m;
                }

                if (buf.remaining() > 0) {
                    ByteBuffer finish = ByteBuffer.allocate(8).order(
                            ByteOrder.LITTLE_ENDIAN);
                    // for big-endian version, do this first:
                    // finish.position(8-buf.remaining());
                    finish.put(buf).rewind();
                    rv ^= finish.getLong();
                    rv *= m;
                }

                rv ^= rv >>> r;
                rv *= m;
                rv ^= rv >>> r;
                buf.order(byteOrder);
                break;
            case FNV1A_64_HASH: {
                rv = FNV_64_INIT;
                int len = k.length();
                for (int i = 0; i < len; i++) {
                    rv ^= k.charAt(i);
                    rv *= FNV_64_PRIME;
                }
            }
            break;
            case FNV1_32_HASH: {
                rv = FNV_32_INIT;
                int len = k.length();
                for (int i = 0; i < len; i++) {
                    rv *= FNV_32_PRIME;
                    rv ^= k.charAt(i);
                }
            }
            break;
            case FNV1A_32_HASH: {
                rv = FNV_32_INIT;
                int len = k.length();
                for (int i = 0; i < len; i++) {
                    rv ^= k.charAt(i);
                    rv *= FNV_32_PRIME;
                }
            }
            break;
            case KETAMA_HASH:
                byte[] bKey = computeMd5(k);
                rv = (long) (bKey[3] & 0xFF) << 24 | (long) (bKey[2] & 0xFF) << 16
                        | (long) (bKey[1] & 0xFF) << 8 | bKey[0] & 0xFF;
                break;

            case MYSQL_HASH:
                int nr2 = 4;
                for (int i = 0; i < k.length(); i++) {
                    rv ^= ((rv & 63) + nr2) * k.charAt(i) + (rv << 8);
                    nr2 += 3;
                }
                break;
            case ELF_HASH:
                long x = 0;
                for (int i = 0; i < k.length(); i++) {
                    rv = (rv << 4) + k.charAt(i);
                    if ((x = rv & 0xF0000000L) != 0) {
                        rv ^= x >> 24;
                        rv &= ~x;
                    }
                }
                rv = rv & 0x7FFFFFFF;
                break;
            case RS_HASH:
                long b = 378551;
                long a = 63689;
                for (int i = 0; i < k.length(); i++) {
                    rv = rv * a + k.charAt(i);
                    a *= b;
                }
                rv = rv & 0x7FFFFFFF;
                break;
            case LUA_HASH:
                int step = (k.length() >> 5) + 1;
                rv = k.length();
                for (int len = k.length(); len >= step; len -= step) {
                    rv = rv ^ (rv << 5) + (rv >> 2) + k.charAt(len - 1);
                }
            case ONE_AT_A_TIME:
                try {
                    int hash = 0;
                    for (byte bt : k.getBytes("utf-8")) {
                        hash += (bt & 0xFF);
                        hash += (hash << 10);
                        hash ^= (hash >>> 6);
                    }
                    hash += (hash << 3);
                    hash ^= (hash >>> 11);
                    hash += (hash << 15);
                    return hash;
                } catch (UnsupportedEncodingException e) {
                    throw new IllegalStateException("Hash function error", e);
                }
            default:
                assert false;
        }

        return rv & 0xffffffffL; /* Truncate to 32-bits */
    }

//        public static void main(String[] args) {
//            HashAlgorithm alg=HashAlgorithm.LUA_HASH;
//            long h=0;
//            long start=System.currentTimeMillis();
//            for(int i=0;i<100000;i++) {
//                h=alg.hash("dddddd");
////                System.out.println(h);
//            }
//            System.out.println(System.currentTimeMillis()-start);
//        }
}