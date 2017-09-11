/*
 * Copyright (C) 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.errai.common.apt.exportfile;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

/**
 * @author Tiago Bento <tfernand@redhat.com>
 */
public final class ExportFileName {

  private static final String PREFIX = "ExportFile_";

  private ExportFileName() {
  }

  public static String encodeAnnotationNameAsExportFileName(final ExportFile exportFile) {
    final String annotationName = exportFile.annotation.getQualifiedName().toString().replace(".", "_");
    return exportFile.moduleName + "_" + randomAlphabetic(6) + "_" + PREFIX + annotationName;
  }

  public static String decodeAnnotationClassNameFromExportFileName(final String exportFileName) {
    return exportFileName.substring(getAnnotationNameBeginIndex(exportFileName)).replace("_", ".");
  }

  private static int getAnnotationNameBeginIndex(final String exportFileName) {
    return exportFileName.indexOf(PREFIX) + PREFIX.length();
  }
}