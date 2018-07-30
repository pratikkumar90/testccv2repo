/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package org.training.setup;

import static org.training.constants.TestemptyextConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import org.training.constants.TestemptyextConstants;
import org.training.service.TestemptyextService;


@SystemSetup(extension = TestemptyextConstants.EXTENSIONNAME)
public class TestemptyextSystemSetup
{
	private final TestemptyextService testemptyextService;

	public TestemptyextSystemSetup(final TestemptyextService testemptyextService)
	{
		this.testemptyextService = testemptyextService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		testemptyextService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return TestemptyextSystemSetup.class.getResourceAsStream("/testemptyext/sap-hybris-platform.png");
	}
}
