package com.rendyrobbani.common.classification.kegiatan;

import com.rendyrobbani.common.classification.fungsi.SubfungsiClassification;
import com.rendyrobbani.common.classification.program.ProgramClassification;

public interface KegiatanClassification extends ProgramClassification, SubfungsiClassification {

	String REGEX = "^(?!0.*|.\\.0{2}.*|X\\.\\d{2}.*|\\d\\.X{2}.*)(X|\\d)\\.(XX|\\d{2})\\.(?!0{2})(\\d{2})\\.((?!0\\.0[1-9]|0\\.[1-9]\\d|[1-9]\\.00)\\d\\.\\d{2})$";

	String getKegiatanCode();

}