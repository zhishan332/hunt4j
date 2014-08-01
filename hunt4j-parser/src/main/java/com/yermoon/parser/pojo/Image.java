package com.yermoon.parser.pojo;

/**
 * 基于html的图片属性
 *
 * @author wangqing
 * @since 1.0.0
 */
public class Image {

    private String title;
    private String src;
    private String alt;
    private int height;
    private int width;
    private String id;
    private String className;
    private long length;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Image{");
        sb.append("title='").append(title).append('\'');
        sb.append(", src='").append(src).append('\'');
        sb.append(", alt='").append(alt).append('\'');
        sb.append(", height='").append(height).append('\'');
        sb.append(", width='").append(width).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", className='").append(className).append('\'');
        sb.append(", length=").append(length);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        return src.equals(image.src);

    }

    @Override
    public int hashCode() {
        return src.hashCode();
    }
}
