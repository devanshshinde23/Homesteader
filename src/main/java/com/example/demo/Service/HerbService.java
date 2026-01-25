package com.example.demo.Service;

import com.example.demo.Model.Herb;


public interface HerbService {

	void addHerb(Herb herb, Integer fid);

	Object getAllHerbs();

}
