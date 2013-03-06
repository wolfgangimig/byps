package com.wilutions.byps.test.servlet;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wilutions.byps.BException;
import com.wilutions.byps.test.api.inl.Actor;
import com.wilutions.byps.test.api.remote.BSkeleton_RemoteInlineInstance;

public class MyRemoteInlineInstance extends BSkeleton_RemoteInlineInstance {

	Actor actor;
	Actor[] actorArray1dim;
	Actor[][][][] actorArray4dim;
	List<Actor> actorList;
	List<List<Actor>> actorListList;
	Set<Actor> actorSet;
	Map<Integer, Actor> actorMap;

	@Override
	public Actor getActor() throws BException, InterruptedException {
		return actor;
	}

	@Override
	public void setActor(Actor act) throws BException, InterruptedException {
		this.actor = act;
	}

	@Override
	public Actor[] getActorArray1dim() throws BException, InterruptedException {
		return actorArray1dim;
	}

	@Override
	public void setActorArray1dim(Actor[] actorArray1dim) throws BException, InterruptedException {
		this.actorArray1dim = actorArray1dim;
	}

	@Override
	public Actor[][][][] getActorArray4dim() throws BException, InterruptedException {
		return actorArray4dim;
	}

	@Override
	public void setActorArray4dim(Actor[][][][] actorArray4dim) throws BException, InterruptedException {
		this.actorArray4dim = actorArray4dim;
	}

	@Override
	public List<Actor> getActorList() throws BException, InterruptedException {
		return actorList;
	}

	@Override
	public void setActorList(List<Actor> actorList) throws BException, InterruptedException {
		this.actorList = actorList;
	}

	@Override
	public List<List<Actor>> getActorListList() throws BException, InterruptedException {
		return actorListList;
	}

	@Override
	public void setActorListList(List<List<Actor>> actorListList) throws BException, InterruptedException {
		this.actorListList = actorListList;
	}

	@Override
	public Set<Actor> getActorSet() throws BException, InterruptedException {
		return actorSet;
	}

	@Override
	public void setActorSet(Set<Actor> actorSet) throws BException, InterruptedException {
		this.actorSet = actorSet;
	}

	@Override
	public Map<Integer, Actor> getActorMap() throws BException, InterruptedException {
		return actorMap;
	}

	@Override
	public void setActorMap(Map<Integer, Actor> actorMap) throws BException, InterruptedException {
		this.actorMap = actorMap;
	}

}
