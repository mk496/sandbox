package com.cg.mobinv.mobileinventory.service.impl;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.cg.mobinv.mobileinventory.common.api.to.PayhdtTo;
import com.cg.mobinv.mobileinventory.logic.api.PayhdtLogic;
import com.cg.mobinv.mobileinventory.service.api.PayhdtService;

@Service
public class PayhdtServiceImpl implements PayhdtService {

    private final String KEY = "Id";
    
	@Inject
    private PayhdtLogic payhdtLogic;

	@Override
	public PayhdtTo createEntity(PayhdtTo to) {
		return this.payhdtLogic.create(to);
	}

	@Override
	public PayhdtTo createEmptyEntity() {
		return this.payhdtLogic.createEmpty();
	}

	@Override
	public PayhdtTo updateEntity(PayhdtTo to) {
		return this.payhdtLogic.update(to);
	}

	@Override
	public void deleteEntity(Map<String, Object> keys) {
		this.payhdtLogic.deleteById((Long) keys.get(this.KEY));
		
	}
	
	public void deleteEntityById(long id) {
		this.payhdtLogic.deleteById(id);
		
	}

	@Override
	public List<PayhdtTo> readAllEntities() {
	
		return this.payhdtLogic.readAll();
	}

	@Override
	public PayhdtTo readEntity(Map<String, Object> keys) {
	
		return this.payhdtLogic.readById((Long) keys.get(this.KEY));
	}

	@Override
	public PayhdtTo setRelation(PayhdtTo source, Object nestedObject) {
	
		return this.payhdtLogic.setRelation(source, nestedObject);
	}

	@Override
	public <S> List<S> readRelatedEntities(PayhdtTo source, Class<S> targetClass) {
		return this.payhdtLogic.readRelatedEntities(source, targetClass);
	}

	@Override
	public <S> S readRelatedEntity(PayhdtTo source, Class<S> targetClass) {

        return this.payhdtLogic.readRelatedEntity(source, targetClass);
	}

	@Override
	public Class<?> getToClassType() {
	
		return PayhdtTo.class;
	}

}
