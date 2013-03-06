package com.wilutions.byps.test.api.remote;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wilutions.byps.test.api.inl.Actor;

/**
 * 
 * @BRemote
 *
 */
public interface RemoteInlineInstance {

	public void setActor(Actor act);
	public Actor getActor();

	public void setActorArray1dim(Actor[] actorArray);
	public Actor[] getActorArray1dim();

	public void setActorArray4dim(Actor[][][][] actorArray);
	public Actor[][][][] getActorArray4dim();

	public void setActorList(List<Actor> actorList);
	public List<Actor> getActorList();
	
	public void setActorListList(List<List<Actor>> actorListList);
	public List<List<Actor>> getActorListList();
	
	public void setActorSet(Set<Actor> actorSet);
	public Set<Actor> getActorSet();
	
	public void setActorMap(Map<Integer, Actor> actorMap);
	public Map<Integer, Actor> getActorMap();
}
