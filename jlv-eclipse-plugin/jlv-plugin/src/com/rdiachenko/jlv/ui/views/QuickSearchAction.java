package com.rdiachenko.jlv.ui.views;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.rdiachenko.jlv.ui.UiStringConstants;
import com.rdiachenko.jlv.ui.preferences.PreferenceManager;

public class QuickSearchAction extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IViewPart part = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage()
				.findView(UiStringConstants.JLV_LOG_LIST_VIEW_ID);

		if (part != null) {
			LogListView view = (LogListView) part;
			boolean isVisible = !PreferenceManager.getLogListViewQuickSearchFieldStatus();
			view.setSearchFieldVisible(isVisible);
			PreferenceManager.setLogListViewQuickSearchFieldStatus(isVisible);
		}
		return null;
	}
}
