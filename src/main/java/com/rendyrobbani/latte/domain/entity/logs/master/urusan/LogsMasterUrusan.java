package com.rendyrobbani.latte.domain.entity.logs.master.urusan;

import com.rendyrobbani.latte.common.marker.HasId;
import com.rendyrobbani.latte.common.marker.HasLoggable;
import com.rendyrobbani.latte.common.marker.HasSubject;
import com.rendyrobbani.latte.domain.entity.base.master.urusan.MasterUrusan;
import com.rendyrobbani.latte.domain.entity.data.master.urusan.DataMasterUrusan;

public interface LogsMasterUrusan extends MasterUrusan, HasId<Long>, HasSubject<DataMasterUrusan>, HasLoggable {

}