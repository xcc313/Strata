/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.platform.pricer.impl.swap;

import static com.opengamma.basics.currency.Currency.GBP;
import static com.opengamma.basics.currency.Currency.USD;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.opengamma.basics.currency.CurrencyAmount;
import com.opengamma.basics.currency.MultiCurrencyAmount;
import com.opengamma.platform.finance.swap.SwapLeg;
import com.opengamma.platform.pricer.PricingEnvironment;
import com.opengamma.platform.pricer.swap.SwapLegPricerFn;

/**
 * Test.
 */
@Test
public class DefaultSwapPricerFnTest {

  private final PricingEnvironment mockEnv = mock(PricingEnvironment.class);

  public void test_presentValue_singleCurrency() {
    SwapLegPricerFn<SwapLeg> mockSwapLegFn = mock(SwapLegPricerFn.class);
    when(mockSwapLegFn.presentValue(mockEnv, SwapDummyData.IBOR_EXPANDED_SWAP_LEG))
        .thenReturn(1000d);
    when(mockSwapLegFn.presentValue(mockEnv, SwapDummyData.FIXED_EXPANDED_SWAP_LEG))
        .thenReturn(-500d);
    DefaultSwapPricerFn test = new DefaultSwapPricerFn(mockSwapLegFn);
    assertEquals(test.presentValue(mockEnv, SwapDummyData.SWAP), MultiCurrencyAmount.of(GBP, 500d));
  }

  public void test_presentValue_crossCurrency() {
    SwapLegPricerFn<SwapLeg> mockSwapLegFn = mock(SwapLegPricerFn.class);
    when(mockSwapLegFn.presentValue(mockEnv, SwapDummyData.IBOR_EXPANDED_SWAP_LEG))
        .thenReturn(1000d);
    when(mockSwapLegFn.presentValue(mockEnv, SwapDummyData.FIXED_EXPANDED_SWAP_LEG_USD))
        .thenReturn(-500d);
    DefaultSwapPricerFn test = new DefaultSwapPricerFn(mockSwapLegFn);
    MultiCurrencyAmount expected = MultiCurrencyAmount.of(CurrencyAmount.of(GBP, 1000d), CurrencyAmount.of(USD, -500d));
    assertEquals(test.presentValue(mockEnv, SwapDummyData.SWAP_CROSS_CURRENCY), expected);
  }

  public void test_futureValue_singleCurrency() {
    SwapLegPricerFn<SwapLeg> mockSwapLegFn = mock(SwapLegPricerFn.class);
    when(mockSwapLegFn.futureValue(mockEnv, SwapDummyData.IBOR_EXPANDED_SWAP_LEG))
        .thenReturn(1000d);
    when(mockSwapLegFn.futureValue(mockEnv, SwapDummyData.FIXED_EXPANDED_SWAP_LEG))
        .thenReturn(-500d);
    DefaultSwapPricerFn test = new DefaultSwapPricerFn(mockSwapLegFn);
    assertEquals(test.futureValue(mockEnv, SwapDummyData.SWAP), MultiCurrencyAmount.of(GBP, 500d));
  }

  public void test_futureValue_crossCurrency() {
    SwapLegPricerFn<SwapLeg> mockSwapLegFn = mock(SwapLegPricerFn.class);
    when(mockSwapLegFn.futureValue(mockEnv, SwapDummyData.IBOR_EXPANDED_SWAP_LEG))
        .thenReturn(1000d);
    when(mockSwapLegFn.futureValue(mockEnv, SwapDummyData.FIXED_EXPANDED_SWAP_LEG_USD))
        .thenReturn(-500d);
    DefaultSwapPricerFn test = new DefaultSwapPricerFn(mockSwapLegFn);
    MultiCurrencyAmount expected = MultiCurrencyAmount.of(CurrencyAmount.of(GBP, 1000d), CurrencyAmount.of(USD, -500d));
    assertEquals(test.futureValue(mockEnv, SwapDummyData.SWAP_CROSS_CURRENCY), expected);
  }

}