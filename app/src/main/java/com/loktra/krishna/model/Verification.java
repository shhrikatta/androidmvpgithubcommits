
package com.loktra.krishna.model;

import com.google.gson.annotations.SerializedName;

public class Verification {

    @SerializedName("payload")
    private Object Payload;
    @SerializedName("reason")
    private String Reason;
    @SerializedName("signature")
    private Object Signature;
    @SerializedName("verified")
    private Boolean Verified;

    public Object getPayload() {
        return Payload;
    }

    public void setPayload(Object payload) {
        Payload = payload;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public Object getSignature() {
        return Signature;
    }

    public void setSignature(Object signature) {
        Signature = signature;
    }

    public Boolean getVerified() {
        return Verified;
    }

    public void setVerified(Boolean verified) {
        Verified = verified;
    }

}
