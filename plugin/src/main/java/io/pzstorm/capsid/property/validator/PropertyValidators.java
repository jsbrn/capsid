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
package io.pzstorm.capsid.property.validator;

public class PropertyValidators {

	/**
	 * Validates if property represents a path to an existing directory.
	 */
	public static final DirectoryPathValidator DIRECTORY_PATH_VALIDATOR = new DirectoryPathValidator();

	/**
	 * Validates if property represents a valid Github {@code URL}.
	 */
	public static final GithubUrlValidator GITHUB_URL_VALIDATOR = new GithubUrlValidator();

	/**
	 * Validates if property represents a valid semantic version.
	 */
	public static final SemVersionValidator SEM_VERSION_VALIDATOR = new SemVersionValidator();
}
