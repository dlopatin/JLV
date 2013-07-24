package com.rdiachenko.jlv.ui.views;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.services.ISourceProviderService;

import com.rdiachenko.jlv.ui.ConstantUiIds;

public class StartServerAction extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// get the window (which is a IServiceLocator)
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		// get the service 
		ISourceProviderService service = (ISourceProviderService) window.getService(ISourceProviderService.class);
		// get our source provider by querying by the variable name 
		ViewSourceProvider viewSourceProvider = (ViewSourceProvider) service
				.getSourceProvider(ConstantUiIds.SERVER_STATE_VARIABLE_ID);

		IViewPart part = window.getActivePage().findView(ConstantUiIds.JLV_MAIN_VIEW_ID);

		if (part != null) {
			JlvView view = (JlvView) part;
			view.getController().startServer();
			viewSourceProvider.setServerStarted(true);
		}
		return null;
	}
}
