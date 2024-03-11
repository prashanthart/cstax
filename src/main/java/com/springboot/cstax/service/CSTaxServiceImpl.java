package com.springboot.cstax.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import java.util.stream.Collectors;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.cstax.dto.Location;
import com.springboot.cstax.dto.PIDummyCollection;
import com.springboot.cstax.dto.PIPojo;
import com.springboot.cstax.dto.Policy;
import com.springboot.cstax.dto.ReportingCode;
import com.springboot.cstax.dto.StatutoryLocation;
import com.springboot.cstax.dto.TaxJurisdiction;
//import com.springboot.cstax.dto.TaxJurisdiction;
import com.springboot.cstax.dto.TaxPolicyEligibilitySolution;
import com.springboot.cstax.repository.CSTaxRepository;

@Service
public class CSTaxServiceImpl {
	
	@Autowired
	CSTaxRepository csTaxRepository;
	
	@Autowired
	PIPojo piPojo;
	
	
	
	public PIPojo passedDataToProcess(List<PIDummyCollection> listpiDummyCollection) {
		
		PIDummyCollection piDummyCollection = listpiDummyCollection.get(0);
		List<TaxPolicyEligibilitySolution> lsTpes = piDummyCollection.getTaxPolicyEligibilitySolutions();
		List<StatutoryLocation> lsSl =  lsTpes.get(0).getStatutoryLocations();
		
		List<Policy> policyList = lsTpes.get(0).getPolicies();
	for(StatutoryLocation sl:lsSl) {
		List<Location> locations = sl.getLocations();
			if(sl.getStatutoryClassificationCode().equals("livedIn")) {
				String state2 = processLocationsList(locations);
				piPojo.setState2(state2);
				
			}
			if(sl.getStatutoryClassificationCode().equals("primaryWorkedIn")) {
				String state1 = processLocationsList(locations);
				piPojo.setState1(state1);
				piPojo.setSuiState(state1);
				
			
			}
			if(sl.getStatutoryClassificationCode().equals("workedIn")) {

				String state1 = processLocationsList(locations);
				piPojo.setState1(state1);
				piPojo.setSuiState(state1);

			
			}

		}
	
	processPolicies(policyList);
	
		return piPojo;
	}
	
	
	public String processLocationsList(List<Location> locations) {
	
//		locations.stream()
//		.filter(location->location.getTaxJurisdictions().stream()
//				.filter())
		for(Location location:locations) {
			String code =  location.getTaxJurisdictions().stream()
			.filter(taxJurisdiction->taxJurisdiction.getJurisdictionLevelCode().getCode().equals("STATE")).collect(Collectors.toList()).get(0).getJurisdictionCode().getCode();
			return code;
		}
		
		return "";
	}
	
	public void processPolicies(List<Policy> policyList){
		List<Policy> newPolicyList = new ArrayList<>();
		
		for(Policy policy:policyList) {
			Optional<ReportingCode> optionalReportingCode =  policy.getReportingCodes().stream()
			.filter(reportingCodes->reportingCodes.getName().equals("adpCode") && 
					checkIsFourDigitNumber(reportingCodes.getCode())).findFirst();
			if(optionalReportingCode.isPresent()) {
				newPolicyList.add(policy);
			}
		}
		
	}
	
	public boolean checkIsFourDigitNumber(String code) {
		
		try {
			Integer.parseInt(code);
			if(code.length()==4) {
				return true;
			}
			return false;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
	
	
}
