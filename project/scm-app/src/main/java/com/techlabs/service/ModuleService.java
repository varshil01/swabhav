package com.techlabs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.entity.Module;
import com.techlabs.repository.ModuleRepo;

@Service("moduleservice")
public class ModuleService {
	@Autowired
	private ModuleRepo module_repo;

	public List<Module> GetAllModules() {
		return this.module_repo.GetAllModules();
	}

	public Module getModuleById(long module_id){
		return this.module_repo.getModuleById(module_id);
	}
	public ModuleRepo getModule_repo() {
		return module_repo;
	}

	@Autowired
	public void setModule_repo(ModuleRepo module_repo) {
		this.module_repo = module_repo;
	}

}
