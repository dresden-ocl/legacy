package tudresden.ocl20.pivot.tools.template.sql;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;

import tudresden.ocl20.pivot.tools.template.ITemplateGroup;
import tudresden.ocl20.pivot.tools.template.TemplatePlugin;
import tudresden.ocl20.pivot.tools.template.exception.TemplateException;

public class SQLTemplate {

	public static void loadSQLTemplates() {

		List<URL> streams = new LinkedList<URL>();
		URL stream = null;
		URL stream2 = null;
		ITemplateGroup standardGroup = null;

		try {
			stream = getUrl("/resources/templates/Standard.stg");
			stream2 = getUrl("/resources/templates/Standard-inv.stg");
			streams.add(stream);
			streams.add(stream2);
			standardGroup = TemplatePlugin.getTemplateGroupRegistry()
					.addDefaultTemplateGroup("Standard(SQL)", null);
			standardGroup.addFiles(streams);
		} catch (TemplateException e) {
			/* FIXME Replace with logging message. */
			e.printStackTrace();
		} catch (IOException e) {
			/* FIXME Replace with logging message. */
			e.printStackTrace();
		}

		try {
			stream = getUrl("/resources/templates/MySQL.stg");
			stream2 = getUrl("/resources/templates/MySQL-inv.stg");
			streams = new LinkedList<URL>();
			streams.add(stream);
			streams.add(stream2);
			ITemplateGroup mysqlGroup;
			mysqlGroup = TemplatePlugin.getTemplateGroupRegistry()
					.addDefaultTemplateGroup("MySQL(SQL)", standardGroup);
			mysqlGroup.addFiles(streams);
		} catch (TemplateException e) {
			/* FIXME Replace with logging message. */
			e.printStackTrace();
		} catch (IOException e) {
			/* FIXME Replace with logging message. */
			e.printStackTrace();
		}

		try {
			stream = getUrl("/resources/templates/Oracle8i.stg");
			stream2 = getUrl("/resources/templates/Oracle8i-inv.stg");
			streams = new LinkedList<URL>();
			streams.add(stream);
			streams.add(stream2);
			ITemplateGroup oracleGroup;
			oracleGroup = TemplatePlugin.getTemplateGroupRegistry()
					.addDefaultTemplateGroup("Oracle 8i(SQL)", standardGroup);
			oracleGroup.addFiles(streams);
		} catch (TemplateException e) {
			/* FIXME Replace with logging message. */
			e.printStackTrace();
		} catch (IOException e) {
			/* FIXME Replace with logging message. */
			e.printStackTrace();
		}

		try {
			stream = getUrl("/resources/templates/PostgreSQL81.stg");
			streams = new LinkedList<URL>();
			streams.add(stream);
			streams.add(stream2);
			ITemplateGroup postgreGroup;
			postgreGroup = TemplatePlugin.getTemplateGroupRegistry()
					.addDefaultTemplateGroup("PostgreSQL 8.1(SQL)",
							standardGroup);
			postgreGroup.addFiles(streams);
		} catch (TemplateException e) {
			/* FIXME Replace with logging message. */
			e.printStackTrace();
		} catch (IOException e) {
			/* FIXME Replace with logging message. */
			e.printStackTrace();
		}
	}

	/**
	 * Helper method to get the URL for a given resource in this plug-in.
	 * 
	 * @param path
	 *            The path of the resource.
	 * @throws IOException
	 */
	private static URL getUrl(String path) throws IOException {

		URL fileLocation;
		File file;

		if (Platform.isRunning()) {
			fileLocation = Platform.getBundle(SQLTemplatePlugin.ID)
					.getResource(path);
			fileLocation = FileLocator.resolve(fileLocation);
			file = new File(fileLocation.getFile());
		}

		else {
			File currentLocation = new File("./");
			File bundleFile = null;

			while (currentLocation != null && currentLocation.exists()
					&& currentLocation.isDirectory()) {
				bundleFile = new File(currentLocation.getAbsolutePath()
						+ File.separator + SQLTemplatePlugin.ID);

				if (bundleFile.exists() && bundleFile.isDirectory())
					break;
				else {
					bundleFile = null;
					currentLocation = new File(
							currentLocation.getAbsolutePath() + File.separator
									+ ".." + File.separator);
				}
			}

			if (bundleFile != null)
				file = new File(bundleFile + File.separator + path);

			else
				throw new RuntimeException("Bundle or directory '"
						+ SQLTemplatePlugin.ID + "' was not found.");
		}

		return file.toURI().toURL();
	}
}