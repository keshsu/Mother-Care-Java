package com.mothercare.services;

import java.util.List;

import com.mothercare.dto.TblPrescriptionDto;

public interface PrescriptionsServices {

	public TblPrescriptionDto savePrescription(TblPrescriptionDto prescription);

	public List<TblPrescriptionDto> getAllPrescriptions();

	public TblPrescriptionDto getPrescriptionById(Integer id);

	public void delPrescription(Integer id);

	public TblPrescriptionDto updatePrescription(TblPrescriptionDto prescription);

}
