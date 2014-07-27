package bpo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("InitBPO")
public class InitBPO {
    @Value("${freshsers_count}")
    public Integer fresherCount;
    @Value("${tl_to_fresher_ratio}")
    public Integer tltoFresherRatio;
    @Value("${pm_to_tl_ratio}")
    public Integer pmtoTlRation;

    @Bean
    public List<ICallHandler> createEmployees() {
	final int teamLeadCount = fresherCount.intValue() / tltoFresherRatio.intValue();
	final int projectMgrCount = teamLeadCount / pmtoTlRation.intValue();

	final List<ICallHandler> fresherList = new ArrayList<ICallHandler>(fresherCount.intValue());
	for (int i = 0; i < projectMgrCount; i++) {
	    final ProjectManagerLevel pm = new ProjectManagerLevel();
	    pm.setId(i);
	    for (int j = 0; j < teamLeadCount / projectMgrCount; j++) {
		final TeamLeadLevel tl = new TeamLeadLevel();
		tl.setReportingProjectManager(pm);
		tl.setId(j);
		tl.setStatus(new Random().nextInt(2) == 1 ? BpoConstantsEnum.BUSY.toString() : BpoConstantsEnum.FREE
			.toString());
		for (int k = 0; k < fresherCount.intValue() / teamLeadCount; k++) {
		    final FresherLevel fresher = new FresherLevel();
		    fresher.setReportingTeamLead(tl);
		    fresher.setStatus(new Random().nextInt(2) == 1 ? BpoConstantsEnum.BUSY.toString()
			    : BpoConstantsEnum.FREE.toString());
		    fresher.setId(k);
		    fresherList.add(fresher);
		}
	    }
	}
	return fresherList;
    }
}
