package com.rendyrobbani.latte.domain.entity.base.master.program;

import com.rendyrobbani.latte.domain.entity.base.master.program.MasterProgram;

public interface ReferenceMasterProgram {

	MasterProgram getProgram();

	default String getProgramCode() {
		if (this.getProgram() == null) return null;
		return this.getProgram().getCode();
	}

	default String getProgramName() {
		if (this.getProgram() == null) return null;
		return this.getProgram().getName();
	}

	default String getProgramName(boolean uppercase) {
		if (this.getProgram() == null) return null;
		return this.getProgram().getName();
	}

}