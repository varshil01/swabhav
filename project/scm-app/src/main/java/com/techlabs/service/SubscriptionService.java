package com.techlabs.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.entity.Subscription;
import com.techlabs.repository.SubscriptionRepo;

@Service("subscriptionservice")
public class SubscriptionService {

	@Autowired
	private SubscriptionRepo subscription_repo;

	public long generateRandomId() {
		return Math.abs(UUID.randomUUID().getMostSignificantBits());
	}

	public void saveSubscription(Subscription subscription) {
		this.subscription_repo.saveSubscription(subscription);
	}

	public List<Subscription> getAllSubscriptionOfTenant(String tenant_id) {
		return this.subscription_repo.getAllSubscriptionOfTenant(tenant_id);
	}
	public List<Subscription> getAllSubscriptions() {
		return this.subscription_repo.getAllSubscriptions();
	}
	public Subscription getSubscriptionById(String sub_id){
		return this.subscription_repo.getSubscriptionById(sub_id);
	}
	
	public void changeStateToApprove(Subscription subscription) {
		this.subscription_repo.changeStateToApprove(subscription);
	}
	public void changeStateToReject(Subscription subscription) {
		this.subscription_repo.changeStateToApprove(subscription);
	}
	public SubscriptionRepo getSubscription_repo() {
		return subscription_repo;
	}

	@Autowired
	public void setSubscription_repo(SubscriptionRepo subscription_repo) {
		this.subscription_repo = subscription_repo;
	}

}
