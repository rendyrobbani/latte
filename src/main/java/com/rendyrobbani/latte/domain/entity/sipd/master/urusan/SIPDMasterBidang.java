package com.rendyrobbani.latte.domain.entity.sipd.master.urusan;

import com.rendyrobbani.latte.common.marker.HasId;
import com.rendyrobbani.latte.common.marker.HasSubject;
import com.rendyrobbani.latte.domain.entity.base.master.urusan.MasterBidang;
import com.rendyrobbani.latte.domain.entity.data.master.urusan.DataMasterBidang;

public interface SIPDMasterBidang extends MasterBidang, HasId<Long>, HasSubject<DataMasterBidang> {

}