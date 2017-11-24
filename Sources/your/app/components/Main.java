package your.app.components;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.eof.ERXEC;
import er.extensions.eof.ERXEOControlUtilities;
import er.extensions.eof.ERXFetchSpecification;
import your.app.model.EntityAbstract;
import your.app.model.EntitySub;
import your.app.model.Relation;
import your.app.model._Relation;

public class Main extends BaseComponent {

	private EOEditingContext _editingContext;
	private Relation _relation;

	public Main(WOContext context) {
		super(context);
	}

	public EOEditingContext editingContext() {
		if (_editingContext == null)
			_editingContext = ERXEC.newEditingContext();
		return _editingContext;
	}

	/**
	 * Get the first Relation object
	 * 
	 * @return
	 */
	public Relation relation() {
		if (_relation == null) {
			ERXFetchSpecification<Relation> fetchSpec = new ERXFetchSpecification<Relation>(_Relation.ENTITY_NAME, null,
					Relation.ID.ascs());
			fetchSpec.setFetchLimit(1);
			NSArray<Relation> eoObjects = fetchSpec.fetchObjects(editingContext());
			int count = eoObjects.count();
			if (count > 0)
				_relation = eoObjects.objectAtIndex(0);
			else
				_relation = ERXEOControlUtilities.createAndInsertObject(editingContext(), Relation.class);

		}
		return _relation;
	}

	public WOActionResults createEntity() {
		int relationID = Integer.valueOf(relation().primaryKeyInTransaction());

		EntityAbstract entityAbstract = ERXEOControlUtilities.createAndInsertObject(editingContext(),
				EntityAbstract.class);
		entityAbstract.setRefEntityName(EntitySub.ENTITY_NAME);
		entityAbstract.setRefEntityID(relationID);

		editingContext().saveChanges();

		ERXEOControlUtilities.refreshObject(relation());
		for (EntityAbstract e : relation().entitySubs())
			System.err.println(e); // Print <your.app.model.EntityAbstract

		return null;
	}

	public WOActionResults fetch() {
		_editingContext = null;
		_relation = null;

		for (EntityAbstract e : relation().entitySubs())
			System.err.println(e);
		return null;
	}
}
