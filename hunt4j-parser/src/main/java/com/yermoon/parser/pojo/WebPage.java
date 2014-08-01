package com.yermoon.parser.pojo;

import java.util.Set;

/**
 * Html主要页面元素
 *
 * @author wangqing
 * @since 1.0.0
 */
public abstract class WebPage {
    protected String title;
    protected String url;
    protected Set<Meta> metas;
    protected Set<Image> images;
    protected Set<Link> links;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Meta> getMetas() {
        return metas;
    }

    public void setMetas(Set<Meta> metas) {
        this.metas = metas;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Set<Link> getLinks() {
        return links;
    }

    public void setLinks(Set<Link> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WebPage{");
        sb.append("title='").append(title).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", metas=").append(metas);
        sb.append(", images=").append(images);
        sb.append(", links=").append(links);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebPage webPage = (WebPage) o;

        return url.equals(webPage.url);

    }

    @Override
    public int hashCode() {
        return url.hashCode();
    }
}
