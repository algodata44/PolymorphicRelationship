// DO NOT EDIT.  Make changes to EntitySub.java instead.
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
public abstract class _EntitySub extends your.app.model.EntityAbstract {
  public static final String ENTITY_NAME = "EntitySub";

  // Attribute Keys

  // Relationship Keys
  public static final ERXKey<your.app.model.Relation> RELATION = new ERXKey<your.app.model.Relation>("relation", Type.ToOneRelationship);

  // Attributes

  // Relationships
  public static final String RELATION_KEY = RELATION.key();

  private static final Logger log = LoggerFactory.getLogger(_EntitySub.class);

  @Override
  public EntitySub localInstanceIn(EOEditingContext editingContext) {
    EntitySub localInstance = (EntitySub)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public your.app.model.Relation relation() {
    return (your.app.model.Relation)storedValueForKey(_EntitySub.RELATION_KEY);
  }

  public void setRelation(your.app.model.Relation value) {
    takeStoredValueForKey(value, _EntitySub.RELATION_KEY);
  }

  public void setRelationRelationship(your.app.model.Relation value) {
    log.debug("updating relation from {} to {}", relation(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setRelation(value);
    }
    else if (value == null) {
      your.app.model.Relation oldValue = relation();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EntitySub.RELATION_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _EntitySub.RELATION_KEY);
    }
  }


  public static EntitySub createEntitySub(EOEditingContext editingContext, your.app.model.Relation relation) {
    EntitySub eo = (EntitySub) EOUtilities.createAndInsertInstance(editingContext, _EntitySub.ENTITY_NAME);
    eo.setRelationRelationship(relation);
    return eo;
  }

  public static ERXFetchSpecification<EntitySub> fetchSpecForEntitySub() {
    return new ERXFetchSpecification<EntitySub>(_EntitySub.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EntitySub> fetchAllEntitySubs(EOEditingContext editingContext) {
    return _EntitySub.fetchAllEntitySubs(editingContext, null);
  }

  public static NSArray<EntitySub> fetchAllEntitySubs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EntitySub.fetchEntitySubs(editingContext, null, sortOrderings);
  }

  public static NSArray<EntitySub> fetchEntitySubs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EntitySub> fetchSpec = new ERXFetchSpecification<EntitySub>(_EntitySub.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<EntitySub> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EntitySub fetchEntitySub(EOEditingContext editingContext, String keyName, Object value) {
    return _EntitySub.fetchEntitySub(editingContext, ERXQ.equals(keyName, value));
  }

  public static EntitySub fetchEntitySub(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EntitySub> eoObjects = _EntitySub.fetchEntitySubs(editingContext, qualifier, null);
    EntitySub eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EntitySub that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EntitySub fetchRequiredEntitySub(EOEditingContext editingContext, String keyName, Object value) {
    return _EntitySub.fetchRequiredEntitySub(editingContext, ERXQ.equals(keyName, value));
  }

  public static EntitySub fetchRequiredEntitySub(EOEditingContext editingContext, EOQualifier qualifier) {
    EntitySub eoObject = _EntitySub.fetchEntitySub(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EntitySub that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EntitySub localInstanceIn(EOEditingContext editingContext, EntitySub eo) {
    EntitySub localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
