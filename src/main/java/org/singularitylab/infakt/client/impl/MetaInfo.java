package org.singularitylab.infakt.client.impl;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jakub Dzon
 */
public class MetaInfo {
    private int count;

    @JsonProperty(value = "total_count")
    private int totalCount;

    private String next;

    private String previous;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public MetaInfo withCount(final int count) {
        this.count = count;
        return this;
    }

    public MetaInfo withTotalCount(final int totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public MetaInfo withNext(final String next) {
        this.next = next;
        return this;
    }

    public MetaInfo withPrevious(final String previous) {
        this.previous = previous;
        return this;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MetaInfo{");
        sb.append("count=").append(count);
        sb.append(", totalCount=").append(totalCount);
        sb.append(", next='").append(next).append('\'');
        sb.append(", previous='").append(previous).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
