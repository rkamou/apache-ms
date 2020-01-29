package com.apache.repository;

import com.apache.model.ShippingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingInfoRepository  extends JpaRepository<ShippingInfo,Long> {
}
