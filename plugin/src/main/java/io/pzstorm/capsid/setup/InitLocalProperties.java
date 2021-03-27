/*
 * Storm Capsid - Project Zomboid mod development framework for Gradle.
 * Copyright (C) 2021 Matthew Cain
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package io.pzstorm.capsid.setup;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.groovy.util.Maps;
import org.apache.tools.ant.taskdefs.Input;
import org.gradle.api.tasks.TaskAction;

import io.pzstorm.capsid.CapsidTask;

public class InitLocalProperties extends CapsidTask {

	@Override
	public void configure(String group, String description) {
		super.configure(group, description);
		onlyIf(t -> !LocalProperties.getFile(getProject()).exists());
	}

	@TaskAction
	void execute() throws IOException {

		Map<LocalProperties, String> PROPERTIES_INPUT_MAP = Maps.of(
				LocalProperties.GAME_DIR, "Enter path to game installation directory",
				LocalProperties.IDEA_HOME, "Enter path to IntelliJ IDEA installation directory"
		);
		org.apache.tools.ant.Project antProject = getProject().getAnt().getAntProject();
		Input inputTask = (Input) antProject.createTask("input");
		for (LocalProperties property : LocalProperties.values())
		{
			inputTask.setAddproperty(property.data.name);
			inputTask.setMessage(PROPERTIES_INPUT_MAP.get(property));
			inputTask.execute();
		}
		File localPropertiesFile = LocalProperties.getFile(getProject());
		if (!localPropertiesFile.createNewFile())
		{
			String format = "Unable to create %s file";
			throw new IOException(String.format(format, localPropertiesFile.getName()));
		}
	}
}
