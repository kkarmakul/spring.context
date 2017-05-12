package edu.sibinfo.spring.basic.module05;

import org.springframework.stereotype.Component;

import edu.sibinfo.spring.basic.module05.slc.AbstractLifeCycleChecker;
import edu.sibinfo.spring.basic.module05.util.CommonUtil;

@Component
public class SmartLifeCycleTwo extends AbstractLifeCycleChecker {
	@Override
	public int getPhase() {
		return 0;
	}	
	@Override
	protected void doStart() {
		CommonUtil.waitABit();
	}

	@Override
	protected void doStop() {
		CommonUtil.waitABit();
	}	
}
