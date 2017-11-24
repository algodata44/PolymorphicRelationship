// DO NOT EDIT.  Make changes to Relation.java instead.
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
public abstract class _Relation extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Relation";

  // Attribute Keys
  public static final ERXKey<Integer> ID = new ERXKey<Integer>("id", Type.Attribute);

  // Relationship Keys
  public static final ERXKey<your.app.model.EntitySub> ENTITY_SUBS = new ERXKey<your.app.model.EntitySub>("entitySubs", Type.ToManyRelationship);

  // Attributes
  public static final String ID_KEY = ID.key();

  // Relationships
  public static final String ENTITY_SUBS_KEY = ENTITY_SUBS.key();

  private static final Logger log = LoggerFactory.getLogger(_Relation.class);

  public Relation localInstanceIn(EOEditingContext editingContext) {
    Relation localInstance = (Relation)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer id() {
    return (Integer) storedValueForKey(_Relation.ID_KEY);
  }

  public void setId(Integer value) {
    log.debug( "updating id from {} to {}", id(), value);
    takeStoredValueForKey(value, _Relation.ID_KEY);
  }

  public NSArray<your.app.model.EntitySub> entitySubs() {
    return (NSArray<your.app.model.EntitySub>)storedValueForKey(_Relation.ENTITY_SUBS_KEY);
  }

  public NSArray<your.app.model.EntitySub> entitySubs(EOQualifier qualifier) {
    return entitySubs(qualifier, null, false);
  }

  public NSArray<your.app.model.EntitySub> entitySubs(EOQualifier qualifier, boolean fetch) {
    return entitySubs(qualifier, null, fetch);
  }

  public NSArray<your.app.model.EntitySub> entitySubs(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<your.app.model.EntitySub> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = ERXQ.equals(your.app.model.EntitySub.RELATION_KEY, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        fullQualifier = ERXQ.and(qualifier, inverseQualifier);
      }

      results = your.app.model.EntitySub.fetchEntitySubs(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = entitySubs();
      if (qualifier != null) {
        results = (NSArray<your.app.model.EntitySub>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<your.app.model.EntitySub>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToEntitySubs(your.app.model.EntitySub object) {
    includeObjectIntoPropertyWithKey(object, _Relation.ENTITY_SUBS_KEY);
  }

  public void removeFromEntitySubs(your.app.model.EntitySub object) {
    excludeObjectFromPropertyWithKey(object, _Relation.ENTITY_SUBS_KEY);
  }

  public void addToEntitySubsRelationship(your.app.model.EntitySub object) {
    log.debug("adding {} to entitySubs relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToEntitySubs(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Relation.ENTITY_SUBS_KEY);
    }
  }

  public void removeFromEntitySubsRelationship(your.app.model.EntitySub object) {
    log.debug("removing {} from entitySubs relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromEntitySubs(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Relation.ENTITY_SUBS_KEY);
    }
  }

  public your.app.model.EntitySub createEntitySubsRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  your.app.model.EntitySub.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Relation.ENTITY_SUBS_KEY);
    return (your.app.model.EntitySub) eo;
  }

  public void deleteEntitySubsRelationship(your.app.model.EntitySub object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Relation.ENTITY_SUBS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllEntitySubsRelationships() {
    Enumeration<your.app.model.EntitySub> objects = entitySubs().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteEntitySubsRelationship(objects.nextElement());
    }
  }


  public static Relation createRelation(EOEditingContext editingContext, Integer id
) {
    Relation eo = (Relation) EOUtilities.createAndInsertInstance(editingContext, _Relation.ENTITY_NAME);
    eo.setId(id);
    return eo;
  }

  public static ERXFetchSpecification<Relation> fetchSpec() {
    return new ERXFetchSpecification<Relation>(_Relation.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Relation> fetchAllRelations(EOEditingContext editingContext) {
    return _Relation.fetchAllRelations(editingContext, null);
  }

  public static NSArray<Relation> fetchAllRelations(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Relation.fetchRelations(editingContext, null, sortOrderings);
  }

  public static NSArray<Relation> fetchRelations(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Relation> fetchSpec = new ERXFetchSpecification<Relation>(_Relation.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Relation> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Relation fetchRelation(EOEditingContext editingContext, String keyName, Object value) {
    return _Relation.fetchRelation(editingContext, ERXQ.equals(keyName, value));
  }

  public static Relation fetchRelation(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Relation> eoObjects = _Relation.fetchRelations(editingContext, qualifier, null);
    Relation eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Relation that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Relation fetchRequiredRelation(EOEditingContext editingContext, String keyName, Object value) {
    return _Relation.fetchRequiredRelation(editingContext, ERXQ.equals(keyName, value));
  }

  public static Relation fetchRequiredRelation(EOEditingContext editingContext, EOQualifier qualifier) {
    Relation eoObject = _Relation.fetchRelation(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Relation that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Relation localInstanceIn(EOEditingContext editingContext, Relation eo) {
    Relation localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
