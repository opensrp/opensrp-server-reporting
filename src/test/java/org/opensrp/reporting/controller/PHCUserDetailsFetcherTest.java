package org.opensrp.reporting.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.opensrp.reporting.service.ANMService;

public class PHCUserDetailsFetcherTest {
	
	@Mock
	private ANMService anmService;
	
	private PHCUserDetailsFetcher phcUserDetailsFetcher;
	
	@Before
	public void setUp() throws Exception {
		initMocks(this);
		phcUserDetailsFetcher = new PHCUserDetailsFetcher(anmService);
	}
	
	@Test
	public void shouldDelegateToANMServiceToFetchANMsFromSamePHC() {
		phcUserDetailsFetcher.fetchDetails("demo1");
		
		verify(anmService).anmsInTheSamePHC("demo1");
	}
	
}
