package com.wilutions.byps;

import java.util.HashMap;



public abstract class BInput {
	
	public final BMessageHeader header;
	public final BTransport transport;
	public final BRegistry registry;
	protected final HashMap<Integer,Object> idMap;
	protected Integer currentId;
	
	public BInput(BMessageHeader header, BTransport transport, BRegistry registry) {
		super();
		this.header = header != null ? header : new BMessageHeader();
		this.transport = transport;
		this.registry = registry;
		this.idMap = new HashMap<Integer,Object>();
	}
	
	public abstract Object load() throws BException;
	
	public Object onObjectCreated(Object obj) {
		if (currentId != null) {
			idMap.put(currentId, obj);
		}
		return obj;
	}

	
	// Diese Funktione helfen die Erstellung von Serialisierern 
	// für externe Klassen zu vereinfachen.
	// Es soll möglich sein, für alle BBinaryModel denselben
	// Serialisierer zu verwenden.
	
	public abstract boolean getBoolean(String name);
	public abstract short getShort(String name);
	public abstract int getInt(String name);
	public abstract long getLong(String name);
	public abstract float getFloat(String name);
	public abstract double getDouble(String name);
	public abstract String getString(String name);
}
