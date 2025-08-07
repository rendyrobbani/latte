package com.rendyrobbani.common.classification.kegiatan;

public interface SubkegiatanClassification extends KegiatanClassification {

	String REGEX = "^(?!0.*|.\\.0{2}.*|X\\.\\d{2}.*|\\d\\.X{2}.*)(X|\\d)\\.(XX|\\d{2})\\.(?!0{2})(\\d{2})\\.(?!0\\.0[1-9]|0\\.[1-9]\\d|[1-9]\\.00)(\\d\\.\\d{2})\\.(?!0{4})(\\d{4})$";

	String getSubkegiatanCode();

}