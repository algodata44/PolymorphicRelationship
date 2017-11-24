package your.app.model.migration;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;

public class MyEOModel0 extends ERXMigrationDatabase.Migration {
	@Override
	public NSArray<ERXModelVersion> modelDependencies() {
		return null;
	}

	@Override
	public void downgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
		// DO NOTHING
	}

	@Override
	public void upgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
		System.err.println("MIGRATION");
		ERXMigrationTable entityAbstractTable = database.newTableNamed("Entity");
		entityAbstractTable.newIntegerColumn("id", NOT_NULL);
		entityAbstractTable.newIntegerColumn("refEntityID", NOT_NULL);
		entityAbstractTable.newStringColumn("refEntityName", 50, NOT_NULL);
		entityAbstractTable.create();
		entityAbstractTable.setPrimaryKey("id");

		ERXMigrationTable relationTable = database.newTableNamed("Relation");
		relationTable.newIntegerColumn("id", NOT_NULL);
		relationTable.create();
		relationTable.setPrimaryKey("id");
	}
}