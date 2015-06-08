package org.singularitylab.infakt.client.impl;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jakub Dzon
 */
public abstract class InfaktResponse {

    @JsonProperty("metainfo")
    protected MetaInfo metaInfo;

    public MetaInfo getMetaInfo() {
        return metaInfo;
    }

    public void setMetaInfo(MetaInfo metaInfo) {
        this.metaInfo = metaInfo;
    }
}
