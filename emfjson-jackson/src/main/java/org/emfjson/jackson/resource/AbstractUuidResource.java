package org.emfjson.jackson.resource;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.common.resource.UuidResource;

public abstract class AbstractUuidResource extends ResourceImpl implements UuidResource {

	protected static final Map<EObject, String> DETACHED_EOBJECT_TO_ID_MAP = Collections.synchronizedMap(new WeakHashMap<EObject, String>());
	private Map<String, EObject> idToEObjectMap;
	private Map<EObject, String> eObjectToIDMap;

	public AbstractUuidResource() {
		super();
	}

	public AbstractUuidResource(URI uri) {
		super(uri);
	}

	@Override
	protected boolean isAttachedDetachedHelperRequired() {
		return useIDs() || super.isAttachedDetachedHelperRequired();
	}

	protected boolean useIDs() {
		return eObjectToIDMap != null || idToEObjectMap != null || useUUIDs();
	}

	protected boolean useIDAttributes() {
		return true;
	}

	protected boolean useUUIDs() {
		return false;
	}

	@Override
	public String getID(EObject eObject) {
		if (eObjectToIDMap == null) {
			return null;
		} else {
			return eObjectToIDMap.get(eObject);
		}
	}

	@Override
	protected EObject getEObjectByID(String id) {
		if (idToEObjectMap != null) {
			EObject eObject = idToEObjectMap.get(id);

			if (eObject != null) {
				return eObject;
			}
		}
		return super.getEObjectByID(id);
	}

	@Override
	public String getURIFragment(EObject eObject) {
		String id = getID(eObject);

		if (id != null) {
			return id;
		}
		else {
			return super.getURIFragment(eObject);
		}
	}

	@Override
	public void setID(EObject eObject, String id) {
		Object oldID = id != null ?  getEObjectToIDMap().put(eObject, id) :  
			getEObjectToIDMap().remove(eObject);

		if (oldID != null) {
			getIDToEObjectMap().remove(oldID);
		}

		if (id != null) {
			getIDToEObjectMap().put(id, eObject);
		}
	}

	@Override
	protected void attachedHelper(EObject eObject) {
		super.attachedHelper(eObject);

		String id = getID(eObject);

		if (id == null) {
			if (!isLoading()) {
				id = DETACHED_EOBJECT_TO_ID_MAP.remove(eObject);
				if (id == null) {
					id = EcoreUtil.generateUUID();
				}
				setID(eObject, id);
			}
		} else if (id != null) {
			getIDToEObjectMap().put(id, eObject);
		}
	}

	public Map<String, EObject> getIDToEObjectMap() {
		if (idToEObjectMap == null) {
			idToEObjectMap = new HashMap<String, EObject>();
		}
		return idToEObjectMap;
	}

	public Map<EObject, String> getEObjectToIDMap() {
		if (eObjectToIDMap == null) {
			eObjectToIDMap = new HashMap<EObject, String>();
		}
		return eObjectToIDMap;
	}

}
