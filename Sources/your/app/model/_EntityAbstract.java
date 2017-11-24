// DO NOT EDIT.  Make changes to EntityAbstract.java instead.
package your.app.model;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;

import er.extensions.eof.*;
import er.extensions.eof.ERXKey.Type;
import er.extensions.foundation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public abstract class _EntityAbstract extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EntityAbstract";

  // Attribute Keys
  public static final ERXKey<Integer> REF_ENTITY_ID = new ERXKey<Integer>("refEntityID", Type.Attribute);
  public static final ERXKey<String> REF_ENTITY_NAME = new ERXKey<String>("refEntityName", Type.Attribute);

  // Relationship Keys

  // Attributes
  public static final String REF_ENTITY_ID_KEY = REF_ENTITY_ID.key();
  public static final String REF_ENTITY_NAME_KEY = REF_ENTITY_NAME.key();

  // Relationships

  private static final Logger log = LoggerFactory.getLogger(_EntityAbstract.class);

  public EntityAbstract localInstanceIn(EOEditingContext editingContext) {
    EntityAbstract localInstance = (EntityAbstract)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer refEntityID() {
    return (Integer) storedValueForKey(_EntityAbstract.REF_ENTITY_ID_KEY);
  }

  public void setRefEntityID(Integer value) {
    log.debug( "updating refEntityID from {} to {}", refEntityID(), value);
    takeStoredValueForKey(value, _EntityAbstract.REF_ENTITY_ID_KEY);
  }

  public String refEntityName() {
    return (String) storedValueForKey(_EntityAbstract.REF_ENTITY_NAME_KEY);
  }

  public void setRefEntityName(String value) {
    log.debug( "updating refEntityName from {} to {}", refEntityName(), value);
    takeStoredValueForKey(value, _EntityAbstract.REF_ENTITY_NAME_KEY);
  }


  public static EntityAbstract createEntityAbstract(EOEditingContext editingContext, Integer refEntityID
, String refEntityName
) {
    EntityAbstract eo = (EntityAbstract) EOUtilities.createAndInsertInstance(editingContext, _EntityAbstract.ENTITY_NAME);
    eo.setRefEntityID(refEntityID);
    eo.setRefEntityName(refEntityName);
    return eo;
  }

  public static ERXFetchSpecification<EntityAbstract> fetchSpec() {
    return new ERXFetchSpecification<EntityAbstract>(_EntityAbstract.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EntityAbstract> fetchAllEntityAbstracts(EOEditingContext editingContext) {
    return _EntityAbstract.fetchAllEntityAbstracts(editingContext, null);
  }

  public static NSArray<EntityAbstract> fetchAllEntityAbstracts(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EntityAbstract.fetchEntityAbstracts(editingContext, null, sortOrderings);
  }

  public static NSArray<EntityAbstract> fetchEntityAbstracts(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EntityAbstract> fetchSpec = new ERXFetchSpecification<EntityAbstract>(_EntityAbstract.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<EntityAbstract> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EntityAbstract fetchEntityAbstract(EOEditingContext editingContext, String keyName, Object value) {
    return _EntityAbstract.fetchEntityAbstract(editingContext, ERXQ.equals(keyName, value));
  }

  public static EntityAbstract fetchEntityAbstract(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EntityAbstract> eoObjects = _EntityAbstract.fetchEntityAbstracts(editingContext, qualifier, null);
    EntityAbstract eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EntityAbstract that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EntityAbstract fetchRequiredEntityAbstract(EOEditingContext editingContext, String keyName, Object value) {
    return _EntityAbstract.fetchRequiredEntityAbstract(editingContext, ERXQ.equals(keyName, value));
  }

  public static EntityAbstract fetchRequiredEntityAbstract(EOEditingContext editingContext, EOQualifier qualifier) {
    EntityAbstract eoObject = _EntityAbstract.fetchEntityAbstract(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EntityAbstract that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EntityAbstract localInstanceIn(EOEditingContext editingContext, EntityAbstract eo) {
    EntityAbstract localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
