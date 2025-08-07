package com.rendyrobbani.latte.domain.entity.sipd.master.program;

import com.rendyrobbani.latte.common.marker.HasId;
import com.rendyrobbani.latte.common.marker.HasSubject;
import com.rendyrobbani.latte.domain.entity.base.master.program.MasterProgram;
import com.rendyrobbani.latte.domain.entity.data.master.program.DataMasterProgram;

public interface SIPDMasterProgram extends MasterProgram, HasId<Long>, HasSubject<DataMasterProgram> {

}