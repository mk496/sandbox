package com.cg.mobinv.mobileinventory.logic.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import com.cg.mobinv.mobileinventory.common.api.to.PayhdtTo;
import com.cg.mobinv.mobileinventory.dataaccess.api.PayhdtEntity;
import com.cg.mobinv.mobileinventory.dataaccess.api.MaterialEntity;
import com.cg.mobinv.mobileinventory.dataaccess.api.repository.PayhdtEntityRepository;
import com.cg.mobinv.mobileinventory.logic.api.PayhdtLogic;
import com.google.common.collect.Lists;

@Component
public class PayhdtLogicImpl implements PayhdtLogic {

	@Inject
	private PayhdtEntityRepository payhdtEntityRepository;

	@Inject
	private Mapper mapper;

	@Override
	public List<PayhdtTo> readAll() {
		List<PayhdtEntity> queryResult = Lists.newArrayList(this.payhdtEntityRepository.findAll());
		List<PayhdtTo> resultMapped = queryResult.stream().map(x -> mapToTransferObject(x))
				.collect(Collectors.toList());

		return resultMapped;
	}

	private PayhdtTo mapToTransferObject(PayhdtEntity entity) {
		PayhdtTo payhdtTo = null;
		if (entity != null) {
			payhdtTo = this.mapper.map(entity, PayhdtTo.class);
		}
		return payhdtTo;
	}

	@Override
	public PayhdtTo readById(Long id) {
		return mapToTransferObject(this.payhdtEntityRepository.findOne(id));
	}

	@Override
	public PayhdtTo create(PayhdtTo payhdtTo) {

		PayhdtEntity newEntity = mapToEntity(payhdtTo);
		this.payhdtEntityRepository.save(newEntity);
		return mapToTransferObject(newEntity);
	}

	private PayhdtEntity mapToEntity(PayhdtTo payhdtTo) {
		return this.mapper.map(payhdtTo, PayhdtEntity.class);
	}

	@Override
	public PayhdtTo createEmpty() {
		return new PayhdtTo();
	}

	@Override
	public PayhdtTo update(PayhdtTo payhdtTo) {

		PayhdtEntity entity = mapToEntity(payhdtTo);
        this.payhdtEntityRepository.save(entity);
        return mapToTransferObject(entity);
	}

	@Override
	public PayhdtTo setRelation(PayhdtTo source, Object targetObject) {
		PayhdtTo result = null;
		return result;
	}

	@Override
	public <S> List<S> readRelatedEntities(PayhdtTo source, Class<S> targetClass) {
		List<S> result = null;
		return result;
	}

	@Override
	public <S> S readRelatedEntity(PayhdtTo source, Class<S> targetClass) {
		S result = null;
		return result;
	}

	@Override
	public void deleteById(Long id) {
		this.payhdtEntityRepository.delete(id);

	}

}
