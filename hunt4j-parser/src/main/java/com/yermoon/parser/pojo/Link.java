package com.yermoon.parser.pojo;

/**
 * 基于HTML的<a><a/>
 *
 * @author wangqing
 * @since 1.0.0
 */
public class Link {

    private String href;
    private String target;
    private String className;
    private String id;
    private String title;
    private String text;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Link{");
        sb.append("href='").append(href).append('\'');
        sb.append(", target='").append(target).append('\'');
        sb.append(", className='").append(className).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        return href.equals(link.href);

    }

    @Override
    public int hashCode() {
        return href.hashCode();
    }
}
