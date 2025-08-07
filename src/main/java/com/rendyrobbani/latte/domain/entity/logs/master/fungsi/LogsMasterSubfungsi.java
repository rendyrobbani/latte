package com.rendyrobbani.latte.domain.entity.logs.master.fungsi;

import com.rendyrobbani.latte.common.marker.HasId;
import com.rendyrobbani.latte.common.marker.HasLoggable;
import com.rendyrobbani.latte.common.marker.HasSubject;
import com.rendyrobbani.latte.domain.entity.base.master.fungsi.MasterSubfungsi;
import com.rendyrobbani.latte.domain.entity.data.master.fungsi.DataMasterSubfungsi;

public interface LogsMasterSubfungsi extends MasterSubfungsi, HasId<Long>, HasSubject<DataMasterSubfungsi>, HasLoggable {

}