package com.rendyrobbani.latte.domain.entity.data.master.program;

import com.rendyrobbani.latte.domain.entity.base.master.program.ReferenceMasterProgram;

public interface ReferenceDataMasterProgram extends ReferenceMasterProgram {

	String getProgramId();

	@Override
	default String getProgramCode() {
		return this.getProgramId();
	}

}