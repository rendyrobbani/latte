package com.rendyrobbani.latte.domain.entity.logs.master.fungsi;

import com.rendyrobbani.latte.common.marker.HasId;
import com.rendyrobbani.latte.common.marker.HasLoggable;
import com.rendyrobbani.latte.common.marker.HasSubject;
import com.rendyrobbani.latte.domain.entity.base.master.fungsi.MasterFungsi;
import com.rendyrobbani.latte.domain.entity.data.master.fungsi.DataMasterFungsi;

public interface LogsMasterFungsi extends MasterFungsi, HasId<Long>, HasSubject<DataMasterFungsi>, HasLoggable {

}