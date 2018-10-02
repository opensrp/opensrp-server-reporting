package org.opensrp.reporting.repository.it;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.opensrp.reporting.domain.ANM;
import org.opensrp.reporting.repository.AllANMsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class AllANMsRepositoryIntegrationTest extends ANMReportsIntegrationTestBase {
	
	@Autowired
	private AllANMsRepository repository;
	
	@Test
	@Transactional("anm_report")
	@Rollback
	public void shouldFetchAllANMs() throws Exception {
		ANM anmX = new ANM("ANM X");
		ANM anmY = new ANM("ANM Y");
		template.save(anmX);
		template.save(anmY);
		
		List<ANM> anms = repository.fetchAll();
		
		assertTrue(anms.containsAll(asList(anmX, anmY)));
	}
}
