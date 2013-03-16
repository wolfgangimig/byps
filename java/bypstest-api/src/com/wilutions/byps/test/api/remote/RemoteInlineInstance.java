package com.wilutions.byps.test.api.remote;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wilutions.byps.BException;
import com.wilutions.byps.BRemote;
import com.wilutions.byps.test.api.inl.Actor;

/**
 * 
 */
public interface RemoteInlineInstance extends BRemote {

	public void setActor(Actor act) throws BException, InterruptedException;
	public Actor getActor() throws BException, InterruptedException;

	public void setActorArray1dim(Actor[] actorArray) throws BException, InterruptedException;
	public Actor[] getActorArray1dim() throws BException, InterruptedException;

	public void setActorArray4dim(Actor[][][][] actorArray) throws BException, InterruptedException;
	public Actor[][][][] getActorArray4dim() throws BException, InterruptedException;

	public void setActorList(List<Actor> actorList) throws BException, InterruptedException;
	public List<Actor> getActorList() throws BException, InterruptedException;
	
	public void setActorListList(List<List<Actor>> actorListList) throws BException, InterruptedException;
	public List<List<Actor>> getActorListList() throws BException, InterruptedException;
	
	public void setActorSet(Set<Actor> actorSet) throws BException, InterruptedException;
	public Set<Actor> getActorSet() throws BException, InterruptedException;
	
	public void setActorMap(Map<Integer, Actor> actorMap) throws BException, InterruptedException;
	public Map<Integer, Actor> getActorMap() throws BException, InterruptedException;
}
