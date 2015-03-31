/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.engine.config;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.google.common.collect.ImmutableList;
import com.opengamma.strata.basics.CalculationTarget;
import com.opengamma.strata.collect.Guavate;

/**
 * A set of pricing rules that delegates to multiple underlying sets of rules, returning the first
 * valid configuration it finds.
 */
@BeanDefinition
final class CompositePricingRules implements PricingRules, ImmutableBean {

  /** Delegate pricing rules. */
  @PropertyDefinition(validate = "notNull")
  private final ImmutableList<PricingRules> rules;

  @Override
  public PricingRules composedWith(PricingRules rules) {
    List<PricingRules> newRules = ImmutableList.<PricingRules>builder().addAll(this.rules).add(rules).build();
    return new CompositePricingRules(newRules);
  }

  @Override
  public Optional<EngineFunctionConfig> functionConfig(CalculationTarget target, Measure measure) {
    return rules.stream()
        .map(rule -> rule.functionConfig(target, measure))
        .flatMap(Guavate::stream)
        .findFirst();
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code CompositePricingRules}.
   * @return the meta-bean, not null
   */
  public static CompositePricingRules.Meta meta() {
    return CompositePricingRules.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(CompositePricingRules.Meta.INSTANCE);
  }

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static CompositePricingRules.Builder builder() {
    return new CompositePricingRules.Builder();
  }

  private CompositePricingRules(
      List<PricingRules> rules) {
    JodaBeanUtils.notNull(rules, "rules");
    this.rules = ImmutableList.copyOf(rules);
  }

  @Override
  public CompositePricingRules.Meta metaBean() {
    return CompositePricingRules.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets delegate pricing rules.
   * @return the value of the property, not null
   */
  public ImmutableList<PricingRules> getRules() {
    return rules;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      CompositePricingRules other = (CompositePricingRules) obj;
      return JodaBeanUtils.equal(getRules(), other.getRules());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getRules());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(64);
    buf.append("CompositePricingRules{");
    buf.append("rules").append('=').append(JodaBeanUtils.toString(getRules()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code CompositePricingRules}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code rules} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<ImmutableList<PricingRules>> rules = DirectMetaProperty.ofImmutable(
        this, "rules", CompositePricingRules.class, (Class) ImmutableList.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "rules");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 108873975:  // rules
          return rules;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public CompositePricingRules.Builder builder() {
      return new CompositePricingRules.Builder();
    }

    @Override
    public Class<? extends CompositePricingRules> beanType() {
      return CompositePricingRules.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code rules} property.
     * @return the meta-property, not null
     */
    public MetaProperty<ImmutableList<PricingRules>> rules() {
      return rules;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 108873975:  // rules
          return ((CompositePricingRules) bean).getRules();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code CompositePricingRules}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<CompositePricingRules> {

    private List<PricingRules> rules = ImmutableList.of();

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(CompositePricingRules beanToCopy) {
      this.rules = beanToCopy.getRules();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 108873975:  // rules
          return rules;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 108873975:  // rules
          this.rules = (List<PricingRules>) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public CompositePricingRules build() {
      return new CompositePricingRules(
          rules);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code rules} property in the builder.
     * @param rules  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder rules(List<PricingRules> rules) {
      JodaBeanUtils.notNull(rules, "rules");
      this.rules = rules;
      return this;
    }

    /**
     * Sets the {@code rules} property in the builder
     * from an array of objects.
     * @param rules  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder rules(PricingRules... rules) {
      return rules(ImmutableList.copyOf(rules));
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(64);
      buf.append("CompositePricingRules.Builder{");
      buf.append("rules").append('=').append(JodaBeanUtils.toString(rules));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
