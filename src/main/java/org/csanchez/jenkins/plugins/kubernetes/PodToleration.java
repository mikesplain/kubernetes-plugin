package org.csanchez.jenkins.plugins.kubernetes;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.Serializable;

public class PodToleration extends AbstractDescribableImpl<PodToleration> implements Serializable {

    private String key;
    private String value;
    private String operator;
    private String effect;

    @DataBoundConstructor
    public PodToleration(String key, String value, String operator, String effect) {
        this.key = key;
        this.value = value;
        this.operator = operator;
        this.effect = effect;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PodToleration that = (PodToleration) o;

        return key != null ? key.equals(that.key) : that.key == null;

    }

    @Override
    public int hashCode() {
        return key != null ? key.hashCode() : 0;
    }

    @Extension
    @Symbol("podAnnotation")
    public static class DescriptorImpl extends Descriptor<PodToleration> {
        @Override
        public String getDisplayName() {
            return "Pod Toleration";
        }
    }
}
