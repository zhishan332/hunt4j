package com.yermoon.parser.pojo;

/**
 * HTML <meta> 标签
 *
 * @author wangqing
 * @since 1.0.0
 */
public class Meta {
    private String httpEquiv;
    private String name;
    private String content;
    private String scheme;

    public String getHttpEquiv() {
        return httpEquiv;
    }

    public void setHttpEquiv(String httpEquiv) {
        this.httpEquiv = httpEquiv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Meta{");
        sb.append("httpEquiv='").append(httpEquiv).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", scheme='").append(scheme).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
