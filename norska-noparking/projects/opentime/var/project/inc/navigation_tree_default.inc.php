<?php
/*
	opentime
	$Author: perrick $
	$URL: svn://svn.noparking.net/usr/local/svn/opentime/inc/navigation_tree_default.inc.php $
	$Revision: 10082 $

	Copyright (C) No Parking 2015 - 2018
*/

class Navigation_Tree_Default {
	public $authenticated;
	public $content = "";
	public $tree;
	
	public $customer_id = 0;
	public $project_id = 0;
	public $user_id = 0;
	public $day = 0;
	public $personal_id = 0;
	public $request_id = 0;
	public $contact_id = 0;
	public $view_id = false;
	
	function __construct($authenticated = null, $content = "") {
		$this->authenticated = $authenticated;
		$this->content = $content;
	}

	function selector_for_user() {
		if (!empty($this->content)) {
			$action = link_content("content=".$this->content);
		} else {
			$action = "";
		}
		
		$html = "<form method=\"post\" action=\"".$action."\" name=\"menu_user\" id=\"menu_user\">";
		
		$users = new Users();
		$properties = array(
			'user_access' => $this->authenticated->access,
			'user_id' => $this->authenticated->id,
			'order' => "user.".$GLOBALS['param']['user_menu']." ASC",
		);
		if ($this->view_id == "1") {
			$properties['access'] = "*";
		}
		$users->select($properties);
		
		$users_name = $users->to_array_with_column($GLOBALS['param']['user_menu']);
		if ($this->authenticated instanceof Contact_Authenticated or ($this->authenticated instanceof User_Authenticated and $this->authenticated->is_admin())) {
			$users_name = array('--' => "--") + $users_name;
		}
	
		if (($GLOBALS['param']['useroptions_delegation'] == 1 or $GLOBALS['param']['useroptions_hierarchicalresponsible'] == 1) and ($this->content == "userholidays.php" or $this->content == "usertime.php")) {
			$users_delegated = new Users();
			$properties = array();
			$properties['hierarchicalresponsible'] = $this->authenticated->delegation_ids_received();
			$properties['hierarchicalresponsible'][] = $this->authenticated->id;
			$users_delegated->select($properties);
			$users_delegated_name = $users_delegated->to_array_with_column($GLOBALS['param']['user_menu']);
			foreach ($users_delegated_name as $user_delegated_id => $user_delegated_name) {
				if (!isset($users_name[$user_delegated_id])) {
					$users_name[$user_delegated_id] = $user_delegated_name." *";
				}
			}
		}
		
		$user_id = new Html_Select("user_id", $users_name, $this->user_id);
		$user_id->properties['onchange'] = "this.form.submit()";

		$personal_id = new Html_Input("personal_id", $this->personal_id);
		$day = new Html_Input("day", $this->day);
		$view_id = new Html_Checkbox("view_id", "1", $this->view_id == "1");
		$view_id->properties['class'] = "tooltip";
		$view_id->properties['title'] = __("tooltip: Show archived users");
		$view_id->properties['onchange'] = "this.form.submit()";

		$html .= $user_id->selectbox();
		$html .= $personal_id->input_hidden();
		$html .= $day->input_hidden();
		$html .= $view_id->input_hidden();
		
		$html .= "</form>";
	
		if ($this->authenticated instanceof User_Authenticated and $this->authenticated->is_admin() and $this->view_id !== false) {
			$html .= "<form method=\"post\" action=\"\" name=\"menu_user_checked\" id=\"menu_user_checked\">";
			$html .= $user_id->input_hidden();
			$html .= $personal_id->input_hidden();
			$html .= $day->input_hidden();
			$html .= $view_id->input();
			$html .= "</form>";
		}

		if (sizeof($users_name) > 1) {
			$user_id = new Html_Input("user_id", $users->id_before($this->user_id));
			$submit = new Html_Button("submit", "previous", "&lt;");
			
			$html .= "<form method=\"post\" action=\"\" name=\"menu_user_prev\" id=\"menu_user_prev\">";
			$html .= $user_id->input_hidden();
			$html .= $personal_id->input_hidden();
			$html .= $day->input_hidden();
			$html .= $view_id->input_hidden();
			$html .= $submit->button();
			$html .= "</form>";
	
			$user_id = new Html_Input("user_id", $users->id_after($this->user_id));
			$submit = new Html_Button("submit", "next", "&gt;");
			
			$html .= "<form method=\"post\" action=\"\" name=\"menu_user_next\" id=\"menu_user_next\">";
			$html .= $user_id->input_hidden();
			$html .= $personal_id->input_hidden();
			$html .= $day->input_hidden();
			$html .= $view_id->input_hidden();
			$html .= $submit->button();
			$html .= "</form>";
		}
	
		return $html;
	}
	
	function selector_for_contacts() {
		$html = "<form method=\"post\" action=\"".link_content("content=contacts.php")."\" name=\"menu_contact_next\" id=\"menu_contact_next\">";
		$html .= "<input type=\"hidden\" name=\"action\" value=\"request\" />";
		$html .= "<input type=\"text\" name=\"filtered_contact\" value=\"\" size=\"10\" />";
		$html .= "<input type=\"submit\" value=\"".$GLOBALS['txt_search']."\" class=\"submit\" />";
		$html .= "</form>";
		
		return $html;
	}	

	function selector_for_customers() {
		$customers = new Customers();
		$customers->user_id = $this->authenticated->id;
		if ($this->authenticated->has_at_least_access($GLOBALS['param']['permissions_manageallcustomers'])) {
			$customers->user_access = "aa";
		} else {
			$customers->user_access = $this->authenticated->access;
		}
		if ($this->view_id != 1) {
			$customers->customerstatus_max = (int)$GLOBALS['param']['level_projectstatus'];
		}
		$customers->select();
		
		if ($GLOBALS['param']['layout_projectmenu'] == "autocompleteinput") {
			$customers_names = $customers->names();
			$element = array();
			if (isset($customers_names[$this->customer_id])) {
				$element[$this->customer_id] = $customers_names[$this->customer_id];
			}
			$input = new Html_Input_Ajax("customer_id", link_content("content=customers.ajax.php"), $element);
			$input->properties['submit'] = "yes";
		} else {
			$input = new Html_Select("customer_id", array('--' => "--") + $customers->names(), $this->customer_id);
			$input->properties['onchange'] = "this.form.submit();";
		}
		
		$html = "<form method=\"post\" action=\"\" name=\"menu_customer\" id=\"menu_customer\">";
		if ($GLOBALS['param']['layout_projectmenu'] == "autocompleteinput") {
			$html .= $input->input();
		} else {
			$html .= $input->selectbox();
		}
		$html .= "<input type=\"hidden\" name=\"view_id\" value=\"".$this->view_id."\" />";
		$html .= "</form>";
		
		if ($this->authenticated->has_at_least_access($GLOBALS['param']['permissions_manageallcustomers'])) {
			$html .= "<form method=\"post\" action=\"\" name=\"menu_customer_checked\" id=\"menu_customer_checked\">";
			$selected = "";
			if ($this->view_id == "1") {
				$selected = "checked=\"checked\"";
			}
			$html .= "<input type=\"checkbox\" name=\"view_id\" value=\"1\" ".$selected." onclick=\"this.form.submit()\" />";
			$html .= "<input type=\"hidden\" name=\"customer_id\" value=\"".$this->customer_id."\" />";
			$html .= "</form>";
		}
		
		$first_customer_id = 0;
		$last_customer_id = 0;
		foreach ($customers as $i => $customer) {
			if ($first_customer_id == 0) {
				$first_customer_id = $customer->id;
			}
			$last_customer_id = $customer->id;
			if ($customer->id == $this->customer_id) {
				$prec_customer_id = $customers[($i - 1 + count($customers)) % count($customers)]->id;
				$next_customer_id = $customers[($i + 1) % count($customers)]->id;
			}
		}
		if (!isset($prec_customer_id)) {
			$prec_customer_id = $first_customer_id;
		}
		if (!isset($next_customer_id)) {
			$next_customer_id = $last_customer_id;
		}
		
		$html .= "<form method=\"post\" action=\"\" name=\"menu_customer_prev\" id=\"menu_customer_prev\">";
		$html .= "<input type=\"hidden\" name=\"customer_id\" value=\"".$prec_customer_id."\" />";
		$html .= "<input type=\"hidden\" name=\"view_id\" value=\"".$this->view_id."\" />";
		$html .= "<input type=\"submit\" value=\"&lt;\" class=\"submit\" />";
		$html .= "</form>";
		
		$html .= "<form method=\"post\" action=\"\" name=\"menu_customer_next\" id=\"menu_customer_next\">";
		$html .= "<input type=\"hidden\" name=\"customer_id\" value=\"".$next_customer_id."\" />";
		$html .= "<input type=\"hidden\" name=\"view_id\" value=\"".$this->view_id."\" />";
		$html .= "<input type=\"submit\" value=\"&gt;\" class=\"submit\" />";
		$html .= "</form>";
		
		return $html;
	}

	function selector_for_projects() {
		$projects = new Projects_Collector();
		$projects->user_id = $this->authenticated->id;
		if ($this->authenticated->has_at_least_access($GLOBALS['param']['permissions_manageallprojects'])) {
			$projects->user_access = "aa";
		} elseif ($this->authenticated->access == "a") {
			$projects->user_access = "a_strict";
		} else {
			$projects->user_access = $this->authenticated->access;
		}
		if ($this->view_id != 1) {
			$projects->projectstatus_max = (int)$GLOBALS['param']['level_projectstatus'];
		}
		$projects->set_order("fullname ASC");
		$projects->select();
		
		$properties = array();
		if ($this->view_id != 1) {
			$properties['customerstatus_max'] = (int)$GLOBALS['param']['level_projectstatus'];
		}
		
		if ($GLOBALS['param']['layout_projectmenu'] == "autocompleteinput") {
			$projects_names = $projects->fullnames();
			$element = array();
			if (isset($projects_names[$this->project_id])) {
				$element[$this->project_id] = $projects_names[$this->project_id];
			}
			$input = new Html_Input_Ajax("project_id", link_content("content=projects.ajax.php"), $element);
			$input->properties['submit'] = "yes";
		} else {
			$input = new Html_Select_Multi("customer_id", "project_id", $projects->tree($properties), (int)$this->customer_id, (int)$this->project_id);
			$input->properties['tree_key'] = uniqid();
			$input->properties['onchange'] = "this.form.submit();";
		}
		
		$html = "<form method=\"post\" action=\"\" name=\"menu_project\" id=\"menu_project\">";
		if ($GLOBALS['param']['layout_projectmenu'] == "autocompleteinput") {
			$html .= $input->input();
		} else {
			$html .= $input->doublebox();
		}
		$html .= "<input type=\"hidden\" name=\"view_encours\" value=\"".$this->view_id."\" />";
		$html .= "</form>";
		
		if ($this->authenticated->is_admin() and $this->view_id !== false) {
			$html .= "<form method=\"post\" action=\"\" name=\"menu_project_checked\" id=\"menu_project_checked\">";
			$selected = "";
			if ($this->view_id == "1") {
				$selected = "checked=\"checked\"";
			}
			$html .= "<input type=\"checkbox\" class=\"tooltip\" title=\"".__("tooltip: Show archived projects")."\" name=\"view_encours\" value=\"1\" ".$selected." onclick=\"this.form.submit()\" />";
			$html .= "<input type=\"hidden\" name=\"customer_id\" value=\"".$this->customer_id."\" />";
			$html .= "<input type=\"hidden\" name=\"project_id\" value=\"".$this->project_id."\" />";
			$html .= "</form>";
		}
		
		foreach ($projects as $i => $project) {
			if (!isset($first_project_id)) {
				$first_project_id = $project->id;
			}
			$last_project_id = $project->id;
			if ($project->id == $this->project_id) {
				$prec_project_id = $projects[($i - 1 + count($projects)) % count($projects)]->id;
				$next_project_id = $projects[($i + 1) % count($projects)]->id;
			}
		}
		if (!isset($first_project_id)) {
			$first_project_id = 0;
		}
		if (!isset($last_project_id)) {
			$last_project_id = 0;
		}
		if (!isset($prec_project_id)) {
			$prec_project_id = $first_project_id;
		}
		if (!isset($next_project_id)) {
			$next_project_id = $last_project_id;
		}
		
		$html .= "<form method=\"post\" action=\"\" name=\"menu_project_prev\" id=\"menu_project_prev\">";
		$html .= "<input type=\"hidden\" name=\"project_id\" value=\"".$prec_project_id."\" />";
		$html .= "<input type=\"hidden\" name=\"view_encours\" value=\"".$this->view_id."\" />";
		$html .= "<input type=\"submit\" value=\"&lt;\" class=\"submit\" />";
		$html .= "</form>";
		
		$html .= "<form method=\"post\" action=\"\" name=\"menu_project_next\" id=\"menu_project_next\">";
		$html .= "<input type=\"hidden\" name=\"project_id\" value=\"".$next_project_id."\" />";
		$html .= "<input type=\"hidden\" name=\"view_encours\" value=\"".$this->view_id."\" />";
		$html .= "<input type=\"submit\" value=\"&gt;\" class=\"submit\" />";
		$html .= "</form>";
		
		$html .= "</div>";
		
		return $html;
	}
	
	function selector_for_requests() {
		$html = "<form method=\"post\" action=\"".link_content("content=requests.php")."\" name=\"menu_request_next\" id=\"menu_request_next\">";
		$html .= "<input type=\"hidden\" name=\"action\" value=\"request\" />";
		$html .= "<input type=\"text\" name=\"titre\" value=\"\" size=\"10\" />";
		$html .= "<input type=\"submit\" value=\"".$GLOBALS['txt_search']."\" class=\"submit\" />";
		$html .= "</form>";
		
		return $html;
	}
	
	function selector_for_absences() {
		$personals = new Personals();
		$personals->id_max = $GLOBALS['param']['level_holidays'];
		$personals->archived = 0;
		$personals->set_order("id ASC");
		$personals->select();
		
		$personal_id = new Html_Select("personal_id", array('--' => "--") + $personals->names(), $this->personal_id);
		$personal_id->properties['onchange'] = "this.form.submit()";
		$view_id = new Html_Input("view_id", $this->view_id);
		$day = new Html_Input("day", $this->day);
		
		$html = "<form method=\"post\" action=\"\" name=\"menu_personal\" id=\"menu_personal\">";
		
		$html .= $personal_id->selectbox();
		$html .= $view_id->input_hidden();
		$html .= $day->input_hidden();

		$html .= "</form>";
		
		return $html.$this->selector_for_user();
	}

	function trunk() {
		$trunk = $this->tree;
		foreach ($trunk as $key => $values) {
			unset($trunk['leaves']);
		}
		return $trunk;
	}
	
	function branch_selected() {
		foreach ($this->trunk() as $key => $branch) {
			if (isset($this->tree[$key]['selected']) and $this->tree[$key]['selected'] == "selected") {
				return $this->tree[$key]['leaves'];
			}
		}
		return array();
	}
	
	function build() {
		$this->create_branches();
		$this->add_leaves_on_branches();
		$this->add_missing_links_on_branches();
		$this->mark_selected_branch();
		return $this;
	}
	
	function create_branches() {
		$this->tree = array();
		
		if (isset($this->authenticated)) {
			if ($this->authenticated instanceof Contact_Authenticated) {
				$this->tree['guest'] = array(
					'name' => __("guest access"),
					'selected' => "",
				);
			} elseif ($this->authenticated instanceof User_Authenticated) {
				$this->tree['user'] = array(
					'name' => $GLOBALS['param']['users'],
					'selected' => "",
				);
				if ($this->authenticated->has_access_to_contacts()) {
					$this->tree['contacts'] = array(
						'name' => $GLOBALS['txt_contacts'],
						'selected' => "",
					);
				}
				if ($GLOBALS['param']['ext_activities'] and $this->authenticated->has_access_to_customers()) {
					$this->tree['customers'] = array(
						'name' => $GLOBALS['param']['levels_0'],
						'selected' => "",
					);
				}
				if ($GLOBALS['param']['ext_activities'] and $this->authenticated->has_access_to_projects()) {
					$this->tree['projects'] = array(
						'name' => $GLOBALS['param']['levels_1'],
						'selected' => "",
					);
				}
				if ($GLOBALS['param']['ext_requests']) {
					$this->tree['requests'] = array(
						'name' => $GLOBALS['param']['requests'],
						'selected' => "",
					);
				}
				if ($GLOBALS['param']['ext_followup'] and $this->authenticated->is_root()) {
					$this->tree['followup'] = array(
						'name' => $GLOBALS['txt_followup'],
						'selected' => "",
					);
				}
				if ($GLOBALS['param']['ext_report'] and $this->authenticated->has_at_least_access($GLOBALS['param']['permissions_accessreports'])) {
					$this->tree['report'] = array(
						'name' => __("reporting"),
						'selected' => "",
					);
				}
				if ($GLOBALS['param']['ext_absences'] and $this->authenticated->has_at_least_access($GLOBALS['param']['permissions_manageabsences'])) {
					$this->tree['absences'] = array(
						'name' => $GLOBALS['txt_absences'],
						'selected' => "",
					);
				}
				if ($this->authenticated->is_root()) {
					$this->tree['config'] = array(
						'name' => $GLOBALS['txt_configuration'],
						'selected' => "",
					);
				}
			}
		}
		
		return $this;
	}

	function add_leaves_on_branches() {
		foreach ($this->tree as $key => $branch) {
			$this->add_leaves_on_branch($key);
		}
	}
	
	function add_leaves_on_branch($key) {
		switch ($key) {
			case "user":
				return $this->add_leaves_on_user();
			case "contacts":
				return $this->add_leaves_on_contacts();
			case "customers":
				return $this->add_leaves_on_customers();
			case "projects":
				return $this->add_leaves_on_projects();
			case "requests":
				return $this->add_leaves_on_requests();
			case "followup":
				return $this->add_leaves_on_followup();
			case "report":
				return $this->add_leaves_on_report();
			case "absences":
				return $this->add_leaves_on_absences();
			case "config":
				return $this->add_leaves_on_config();
			case "guest":
				return $this->add_leaves_on_guest();
			default:
				return array();
		}
	}
	
	function add_leaves_on_user() {
		$leaves = array(
			'selector' => array(
				'data' => "<div class=\"forms\">".$this->selector_for_user()."</form>",
			)
		);
		if ($this->authenticated->has_at_least_access($GLOBALS['param']['permissions_adduser']) and $GLOBALS['param']['user_handling']) {
			$leaves['user.php&user_id=no'] = array(
				'name' => $GLOBALS['txt_new'],
				'link' => "user.php&user_id=no",
				'title' => $GLOBALS['status_adda']." ".$GLOBALS['param']['user'],
				'selected' => ($this->content == "user.php" and (int)$this->user_id == 0) ? "selected" : "",
			);
		}
		$leaves['user.php'] = array(
			'name' => $GLOBALS['txt_parameters'],
			'link' => "user.php",
			'title' => $GLOBALS['status_modifyparametersofa']." ".$GLOBALS['param']['user'],
			'selected' => ($this->content == "user.php" and ((int)$this->user_id > 0 or !$GLOBALS['param']['user_handling'] or !$this->authenticated->has_at_least_access($GLOBALS['param']['permissions_adduser']))) ? "selected" : "",
		);
		if ($GLOBALS['param']['user_preferences']) {
			$leaves['userpreferences.php'] = array(
				'name' => $GLOBALS['txt_preferences'],
				'link' => "userpreferences.php",
				'title' => $GLOBALS['status_modifypreferencesofa']." ".$GLOBALS['param']['user'],
				'selected' => ($this->content == "userpreferences.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_timekeeper'] and $GLOBALS['param']['useroptions_dailydetails']) {
			$leaves['useroptionsdateddailydetails.php'] = array(
				'name' => __("typical weeks"),
				'link' => "useroptionsdateddailydetails.php",
				'title' => $GLOBALS['status_modifypreferencesofa']." ".$GLOBALS['param']['user'],
				'selected' => in_array($this->content, array("useroptiondateddailydetails.php", "useroptionsdateddailydetails.php")) ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_activities']) {
			$leaves['userassignment.php'] = array(
				'name' => $GLOBALS['txt_assignment'],
				'link' => "userassignment.php",
				'title' => $GLOBALS['status_modifyassignementofa']." ".$GLOBALS['param']['user'],
				'selected' => ($this->content == "userassignment.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['hours_recurrent']) {
			$leaves['userrecurrents.php'] = array(
				'name' => __('recurrents'),
				'link' => "userrecurrents.php",
				'title' => __('recurrents'),
				'selected' => strpos($this->content, "userrecurrent") !== false ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_chargeplan']) {
			$leaves['userchargeplan.php'] = array(
				'name' => $GLOBALS['txt_chargeplan'],
				'link' => "userchargeplan.php",
				'title' => $GLOBALS['status_modifychargeplanona']." ".$GLOBALS['param']['user'],
				'selected' => ($this->content == "userchargeplan.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_time']) {
			$leaves['usertime.php'] = array(
				'name' => $GLOBALS['txt_time'],
				'link' => "usertime.php",
				'title' => $GLOBALS['status_addtimeona']." ".$GLOBALS['param']['user'],
				'selected' => ($this->content == "usertime.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_timekeeper']) {
			$user = new User();
			$user->load($this->user_id);
			if ($user->has_timekeeper()) {
				$leaves['usertimekeeper.php'] = array(
					'name' => $GLOBALS['txt_timekeeper'],
					'link' => "usertimekeeper.php",
					'title' => $GLOBALS['status_modifytimekeeperofa']." ".$GLOBALS['param']['user'],
					'selected' => ($this->content == "usertimekeeper.php") ? "selected" : "",
				);
			}
		}
		if ($GLOBALS['param']['ext_calendar']) {
			$leaves['usercalendar.php'] = array(
				'name' => $GLOBALS['txt_calendar'],
				'link' => "usercalendar.php",
				'title' => $GLOBALS['status_modifycalendarofa']." ".$GLOBALS['param']['user'],
				'selected' => in_array($this->content, array("usercalendar.php", "userevent.php")) ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_planning']) {
			$leaves['userplanningrequests.php'] = array(
				'name' => $GLOBALS['txt_planning'],
				'link' => "userplanningrequests.php",
				'title' => $GLOBALS['status_modifyplanningofa']." ".$GLOBALS['param']['user'],
				'selected' => ($this->content == $GLOBALS['param']['file_userplanning']) ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_userproject']) {
			$leaves['userprojects.php'] = array(
				'name' => $GLOBALS['param']['levels_1'],
				'link' => "userprojects.php",
				'title' => $GLOBALS['status_consultproject'],
				'selected' => ($this->content == "userprojects.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_holidays'] and is_using_absences($this->user_id)) {
			$leaves['userholidays.php'] = array(
				'name' => $GLOBALS['txt_holidays'],
				'link' => "userholidays.php",
				'title' => $GLOBALS['status_manageholidayrequestsofa']." ".$GLOBALS['param']['user'],
				'selected' => in_array($this->content, array("userholidays.php", "userpersonalrequest.php")) ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_expenses']) {
			$leaves['userexpenses.php'] = array(
				'name' => $GLOBALS['txt_expenses'],
				'link' => "userexpenses.php",
				'title' => $GLOBALS['status_manageexpensesofa']." ".$GLOBALS['param']['user'],
				'selected' => ($this->content == "userexpenses.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_userfeedback']) {
			$leaves['userfeedback.php'] = array(
				'name' => $GLOBALS['param']['feedback'],
				'link' => "userfeedback.php",
				'title' => __("Consult the infos of a %s", array($GLOBALS['param']['user'])),
				'selected' => ($this->content == "userfeedback.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_absencecredit']) {
			$leaves['userabsencecredits.php'] = array(
				'name' => $GLOBALS['txt_absencecredit'],
				'link' => "userabsencecredits.php",
				'title' => $GLOBALS['status_consultabsencecreditofa']." ".$GLOBALS['param']['user'],
				'selected' => ($this->content == "userabsencecredits.php") ? "selected" : "",
			);
		}
		$this->tree['user']['leaves'] = $leaves;
		return $this;
	}
	
	function add_leaves_on_contacts() {
		$leaves = array(
			'selector' => array(
				'data' => "<div class=\"forms\">".$this->selector_for_contacts()."</form>",
			)
		);
		$leaves['contacts.php'] = array(
			'name' => $GLOBALS['txt_search'],
			'link' => "contacts.php",
			'title' => $GLOBALS['status_searchcontacts'],
			'selected' => ($this->content == "contacts.php") ? "selected" : "",
		);
		$this->tree['contacts']['leaves'] = $leaves;
		return $this;
	}
	
	function add_leaves_on_customers() {
		$leaves = array(
			'selector' => array(
				'data' => "<div class=\"forms\">".$this->selector_for_customers()."</form>",
			)
		);
		if ($GLOBALS['param']['level_0_handling']) {
			$leaves['customer.php&customer_id=no'] = array(
				'name' => $GLOBALS['txt_new'],
				'link' => "customer.php&customer_id=no",
				'title' => $GLOBALS['status_adda']." ".$GLOBALS['param']['newlevel_0'],
				'selected' => ($this->content == "customer.php" and (int)$this->customer_id <= 0) ? "selected" : "",
			);
		}
		$leaves['customer.php'] = array(
			'name' => $GLOBALS['txt_parameters'],
			'link' => "customer.php",
			'title' => $GLOBALS['status_modifyparametersofa']." ".$GLOBALS['param']['level_0'],
			'selected' => ($this->content == "customer.php" and ((int)$this->customer_id > 0 or !$GLOBALS['param']['level_0_handling'])) ? "selected" : "",
		);
		$this->tree['customers']['leaves'] = $leaves;
		return $this;
	}
	
	function add_leaves_on_projects() {
		$leaves = array(
			'selector' => array(
				'data' => "<div class=\"forms\">".$this->selector_for_projects()."</form>",
			)
		);
		if ($GLOBALS['param']['level_1_handling']) {
			$leaves['project.php&project_id=no'] = array(
				'name' => $GLOBALS['txt_new'],
				'link' => "project.php&customer_id=".$this->customer_id."&project_id=no",
				'title' => $GLOBALS['status_adda']." ".$GLOBALS['param']['newlevel_1'],
				'selected' => ($this->content == "project.php" and (!is_int($this->project_id) or $this->project_id == 0)) ? "selected" : "",
			);
		}
		$leaves['project.php'] = array(
			'name' => $GLOBALS['txt_parameters'],
			'link' => "project.php",
			'title' => $GLOBALS['status_modifyparametersofa']." ".$GLOBALS['param']['level_1'],
			'selected' => ($this->content == "project.php" and ((is_int($this->project_id) and $this->project_id != 0) or !$GLOBALS['param']['level_1_handling'])) ? "selected" : "",
		);
		if ($GLOBALS['param']['ext_quotes']) {
			$leaves['projectquotes.php'] = array(
				'name' => $GLOBALS['txt_quotes'],
				'link' => "projectquotes.php",
				'title' => $GLOBALS['status_modifyquoteofa']." ".$GLOBALS['param']['level_1'],
				'selected' => preg_match("/^projectquotes?\.php$/", $this->content) ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_invoices']) {
			$leaves['invoices.php'] = array(
				'name' => $GLOBALS['txt_invoices'],
				'link' => "invoices.php",
				'title' => $GLOBALS['status_modifyinvoiceofa']." ".$GLOBALS['param']['level_1'],
				'selected' => preg_match("/^invoices?\.php$/", $this->content) ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_finances'] or $GLOBALS['param']['ext_estimates']) {
			$leaves['projectestimates.php'] = array(
				'name' => $GLOBALS['txt_estimates'],
				'link' => "projectestimates.php",
				'title' => $GLOBALS['status_modifyestimatesofa']." ".$GLOBALS['param']['level_1'],
				'selected' => ($this->content == "projectestimates.php") ? "selected" : "",
			);
		}
		$leaves['projectdetails.php'] = array(
			'name' => __("progress"),
			'link' => "projectdetails.php",
			'title' => $GLOBALS['status_consultstatus'],
			'selected' => ($this->content == "projectdetails.php") ? "selected" : "",
		);
		if ($this->authenticated->is_admin() and in_array($this->authenticated->id, input_list_2_array($GLOBALS['param']['authorizations_managelabordetails']))) {
			$leaves['projectlabordetails.php'] = array(
				'name' => __("labor costs"),
				'link' => "projectlabordetails.php",
				'selected' => ($this->content == "projectlabordetails.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_chargeplan']) {
			$leaves['projectchargeplan.php'] = array(
				'name' => $GLOBALS['txt_chargeplan'],
				'link' => "projectchargeplan.php",
				'title' => $GLOBALS['status_modifychargeplanona']." ".$GLOBALS['param']['level_1'],
				'selected' => ($this->content == "projectchargeplan.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_leftovers']) {
			$leaves['projectleftovers.php'] = array(
				'name' => __("Leftovers"),
				'link' => "projectleftovers.php",
				'title' => __("Modify the leftovers"),
				'selected' => ($this->content == "projectleftovers.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_time']) {
			$leaves['projecttime.php'] = array(
				'name' => $GLOBALS['txt_time'],
				'link' => "projecttime.php",
				'title' => $GLOBALS['status_addtimeona']." ".$GLOBALS['param']['level_1'],
				'selected' => ($this->content == "projecttime.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_calendar']) {
			$leaves['projectcalendar.php'] = array(
				'name' => $GLOBALS['txt_calendar'],
				'link' => "projectcalendar.php",
				'title' => $GLOBALS['status_modifycalendarofa']." ".$GLOBALS['param']['level_1'],
				'selected' => ($this->content == "projectcalendar.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_planning']) {
			$leaves['projectplanningrequests.php'] = array(
				'name' => $GLOBALS['txt_planning'],
				'link' => "projectplanningrequests.php",
				'title' => $GLOBALS['status_modifyplanningofa']." ".$GLOBALS['param']['level_1'],
				'selected' => ($this->content == "projectplanningrequests.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_finances'] or $GLOBALS['param']['ext_estimates']) {
			$leaves['projectaccounts.php'] = array(
				'name' => $GLOBALS['txt_invoicing'],
				'link' => "projectaccounts.php",
				'title' => $GLOBALS['status_modifyaccounting'],
				'selected' => ($this->content == "projectaccounts.php") ? "selected" : "",
			);
		}
		$this->tree['projects']['leaves'] = $leaves;
		return $this;
	}
	
	function add_leaves_on_requests() {
		$leaves = array(
			'selector' => array(
				'data' => "<div class=\"forms\">".$this->selector_for_requests()."</form>",
			)
		);
		$leaves['requests.php'] = array(
			'name' => $GLOBALS['txt_search'],
			'link' => "requests.php",
			'title' => $GLOBALS['status_searchrequests'],
			'selected' => ($this->content == "requests.php") ? "selected" : "",
		);
		$leaves['request.php&request_id=no'] = array(
			'name' => $GLOBALS['txt_new'],
			'link' => "request.php&request_id=no",
			'title' => $GLOBALS['status_adda']." ".$GLOBALS['param']['request'],
			'selected' => ($this->content == "request.php" and (int)$this->request_id <= 0) ? "selected" : "",
		);
		$leaves['request.php'] = array(
			'name' => $GLOBALS['txt_detail'],
			'link' => "request.php",
			'title' => $GLOBALS['status_modifyparametersofa']." ".$GLOBALS['param']['request'],
			'selected' => ($this->content == "request.php" and (int)$this->request_id > 0) ? "selected" : "",
		);
		$this->tree['requests']['leaves'] = $leaves;
		return $this;
	}
	
	function add_leaves_on_followup() {
		$leaves = array();
		if ($GLOBALS['param']['ext_finances'] or $GLOBALS['param']['ext_estimates']) {
			$leaves['followupprojects.php'] = array(
				'name' => $GLOBALS['txt_console']." ".$GLOBALS['param']['level_1'],
				'link' => "followupprojects.php",
				'title' => "",
				'selected' => ($this->content == "followupprojects.php") ? "selected" : "",
			);
			$leaves['followupcrosseddetails.php'] = array(
				'name' => $GLOBALS['txt_crosseddetails'],
				'link' => "followupcrosseddetails.php",
				'title' => "",
				'selected' => ($this->content == "followupcrosseddetails.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_finances']) {
			$leaves['followupsalefigures.php'] = array(
				'name' => $GLOBALS['param']['sales'],
				'link' => "followupsalefigures.php",
				'title' => "",
				'selected' => preg_match("/^followupsalefigure/", $this->content) ? "selected" : "",
			);
			$leaves['followuppurchases.php'] = array(
				'name' => $GLOBALS['param']['purchases'],
				'link' => "followuppurchases.php",
				'title' => "",
				'selected' => ($this->content == "followuppurchases.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_timeannual']) {
			$leaves['followupannualtransfer.php'] = array(
				'name' => __("annualization"),
				'link' => "followupannualtransfer.php",
				'title' => "",
				'selected' => ($this->content == "followupannualtransfer.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_chargeplan']) {
			$leaves['followupchargeplan.php'] = array(
				'name' => $GLOBALS['txt_chargeplan'],
				'link' => "followupchargeplan.php",
				'title' => "",
				'selected' => ($this->content == "followupchargeplan.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['followup_organization']) {
			$leaves['followuporganization.php'] = array(
				'name' => __("organization"),
				'link' => "followuporganization.php",
				'title' => "",
				'selected' => ($this->content == "followuporganization.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_finances']) {
			$leaves['followupestimates.php'] = array(
				'name' => $GLOBALS['txt_financialestimates'],
				'link' => "followupestimates.php",
				'title' => "",
				'selected' => ($this->content == "followupestimates.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_calendar']) {
			$leaves['followupcalendar.php'] = array(
				'name' => $GLOBALS['txt_calendar'],
				'link' => "followupcalendar.php",
				'title' => "",
				'selected' => ($this->content == "followupcalendar.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_expenses']) {
			$leaves['followupexpenses.php'] = array(
				'name' => $GLOBALS['txt_expenses'],
				'link' => "followupexpenses.php",
				'title' => "",
				'selected' => ($this->content == "followupexpenses.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_planning']) {
			$leaves["followupplanningrequests.php"] = array(
				'name' => $GLOBALS['txt_planning'],
				'link' => "followupplanningrequests.php",
				'title' => "",
				'selected' => ($this->content == "followupplanningrequests.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_time']) {
			$leaves['followupreminder.php'] = array(
				'name' => $GLOBALS['txt_reminder'],
				'link' => "followupreminder.php",
				'title' => "",
				'selected' => ($this->content == "followupreminder.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_analytical']) {
			$leaves['followupsalaries.php'] = array(
				'name' => $GLOBALS['txt_salaries'],
				'link' => "followupsalaries.php",
				'title' => "",
				'selected' => ($this->content == "followupsalaries.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_taxrefund']) {
			$leaves['followuptaxrefund.php'] = array(
				'name' => $GLOBALS['txt_taxrefund'],
				'link' => "followuptaxrefund.php",
				'title' => "",
				'selected' => ($this->content == "followuptaxrefund.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['validation_lock']) {
			$leaves['followupvalidationlocks.php'] = array(
				'name' => $GLOBALS['txt_validationlock'],
				'link' => "followupvalidationlocks.php",
				'title' => "",
				'selected' => ($this->content == "followupvalidationlocks.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_time'] and $GLOBALS['param']['followup_time']) {
			$leaves['followuptime.php'] = array(
				'name' => $GLOBALS['txt_time'],
				'link' => "followuptime.php",
				'title' => "",
				'selected' => ($this->content == "followuptime.php") ? "selected" : "",
			);
		}
		$this->tree['followup']['leaves'] = $leaves;
		return $this;
	}
	
	function add_leaves_on_report() {
		$leaves = array();
		if (!isset($this->authenticated) or ($this->authenticated instanceof User_Authenticated and $this->authenticated->has_at_least_access($GLOBALS['param']['permissions_managereports']))) {
			if ($GLOBALS['param']['report_reports']) {
				$leaves['reports.php'] = array(
					'name' => $GLOBALS['txt_report'],
					'link' => "reports.php",
					'title' => "",
					'selected' => ($this->content == "reports.php") ? "selected" : "",
				);
			}
			if ($GLOBALS['param']['report_synthesis']) {
				$leaves['reportsynthesis.php'] = array(
					'name' => $GLOBALS['txt_synthesis'],
					'link' => "reportsynthesis.php",
					'title' => "",
					'selected' => ($this->content == "reportsynthesis.php") ? "selected" : "",
				);
			}
			if ($GLOBALS['param']['report_excel']) {
				$leaves['reportexcel.php'] = array(
					'name' => $GLOBALS['txt_excelexport'],
					'link' => "reportexcel.php",
					'title' => "",
					'selected' => ($this->content == "reportexcel.php") ? "selected" : "",
				);
			}
			if ($GLOBALS['param']['report_analysis']) {
				$leaves['reportanalysis.php'] = array(
					'name' => $GLOBALS['txt_analysis'],
					'link' => "reportanalysis.php",
					'title' => "",
					'selected' => ($this->content == "reportanalysis.php") ? "selected" : "",
				);
			}
			if ($GLOBALS['param']['report_scoreboard']) {
				$leaves['reportscoreboard.php'] = array(
					'name' => $GLOBALS['txt_scoreboard'],
					'link' => "reportscoreboard.php",
					'title' => "",
					'selected' => ($this->content == "reportscoreboard.php") ? "selected" : "",
				);
			}
			if ($GLOBALS['param']['report_userboard'] and $GLOBALS['param']['ext_time']) {
				$leaves['reportuserboard.php'] = array(
					'name' => __("%s validation", array($GLOBALS['param']['users'])),
					'link' => "reportuserboard.php",
					'title' => "",
					'selected' => ($this->content == "reportuserboard.php") ? "selected" : "",
				);
			}
		}
		$this->tree['report']['leaves'] = $leaves;
		return $this;
	}
	
	function add_leaves_on_absences() {
		$leaves = array();
		if ($GLOBALS['param']['ext_absences']) {
			$leaves['selector'] = array(
				'data' => "<div class=\"forms\">".$this->selector_for_absences()."</form>",
			);
			$leaves['absenceboard.php'] = array(
				'name' => $GLOBALS['txt_synthesis'],
				'link' => "absenceboard.php",
				'title' => $GLOBALS['status_consultabsencesof']." ".$GLOBALS['param']['users'],
				'selected' => $this->content == "absenceboard.php" ? "selected" : "",
			);
			$leaves['absencefeedback.php'] = array(
				'name' => $GLOBALS['param']['feedback'],
				'link' => "absencefeedback.php",
				'title' => __("Consult the informations"),
				'selected' => $this->content == "absencefeedback.php" ? "selected" : "",
			);
			$leaves['absencebalance.php'] = array(
				'name' => $GLOBALS['txt_balance'],
				'link' => "absencebalance.php",
				'title' => $GLOBALS['status_consultbalanceof']." ".$GLOBALS['param']['users'],
				'selected' => $this->content == "absencebalance.php" ? "selected" : "",
			);
			$leaves['absenceadmin.php'] = array(
				'name' => $GLOBALS['txt_detail'],
				'link' => "absenceadmin.php",
				'title' => $GLOBALS['status_modifyabsencesof']." ".$GLOBALS['param']['users'],
				'selected' => $this->content == "absenceadmin.php" ? "selected" : "",
			);
			if ($GLOBALS['param']['ext_holidays']) {
				$leaves['absencevalidation.php'] = array(
					'name' => $GLOBALS['txt_validation'],
					'link' => "absencevalidation.php",
					'title' => $GLOBALS['status_validateholidayrequests'],
					'selected' => $this->content == "absencevalidation.php" ? "selected" : "",
				);
			}
			if ($GLOBALS['param']['ext_absencecredit']) {
				$leaves['absencecredits.php'] = array(
					'name' => $GLOBALS['txt_absencecredit'],
					'link' => "absencecredits.php",
					'title' => "",
					'selected' => $this->content == "absencecredits.php" ? "selected" : "",
				);
			}
			if ($this->authenticated->is_root_for_absences() and $GLOBALS['param']['ext_payrollelements']) {
				$leaves['absencepayrollelements.php'] = array(
					'name' => __("payroll elements"),
					'link' => "absencepayrollelements.php",
					'title' => "",
					'selected' => $this->content == "absencepayrollelements.php" ? "selected" : "",
				);
			}
		}
		$this->tree['absences']['leaves'] = $leaves;
		return $this;
	}
	
	function add_leaves_on_config() {
		$leaves = array();
		$leaves['configoptions.php'] = array(
			'name' => $GLOBALS['txt_options'],
			'link' => "configoptions.php",
			'title' => "",
			'selected' => ($this->content == "configoptions.php") ? "selected" : "",
		);
		if ($GLOBALS['param']['ext_time'] or $GLOBALS['param']['ext_timekeeper']) {
			$leaves['configbankholidays.php'] = array(
				'name' => $GLOBALS['txt_bankholidays'],
				'link' => "configbankholidays.php",
				'title' => "",
				'selected' => ($this->content == "configbankholidays.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_absences'] or $GLOBALS['param']['ext_holidays']) {
			$leaves['configabsences.php'] = array(
				'name' => $GLOBALS['txt_absences'],
				'link' => "configabsences.php",
				'title' => "",
				'selected' => ($this->content == "configabsences.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_contacts']) {
			$leaves['configcontacts.php'] = array(
				'name' => $GLOBALS['txt_contacts'],
				'link' => "configcontacts.php",
				'title' => $GLOBALS['status_modifyoptionsof']." ".$GLOBALS['txt_contacts'],
				'selected' =>($this->content == "configcontacts.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_finances'] or $GLOBALS['param']['ext_estimates']) {
			$leaves['configratestask.php'] = array(
				'name' => __("cost per %s", array($GLOBALS['param']['task'])),
				'link' => "configratestask.php",
				'title' => "",
				'selected' => ($this->content == "configratestask.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_finances'] and $GLOBALS['param']['cost_rateuser'] and in_array($this->authenticated->id, input_list_2_array($GLOBALS['param']['authorizations_managelabordetails']))) {
			$leaves['configratesuser.php'] = array(
				'name' => __("cost per %s", array($GLOBALS['param']['user'])),
				'link' => "configratesuser.php",
				'title' => "",
				'selected' => ($this->content == "configratesuser.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_expenses']) {
			$leaves['configexpenserates.php'] = array(
				'name' => $GLOBALS['txt_expenses'],
				'link' => "configexpenserates.php",
				'title' => "",
				'selected' => ($this->content == "configexpenserates.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_requests']) {
			$leaves['configrequests.php'] = array(
				'name' => $GLOBALS['param']['requests'],
				'link' => "configrequests.php",
				'title' => "",
				'selected' => ($this->content == "configrequests.php") ? "selected" : "",
			);
		}
		if ($GLOBALS['param']['ext_currencies']) {
			$leaves['configcurrencies.php'] = array(
				'name' => __("currencies"),
				'link' => "configcurrencies.php",
				'title' => "",
				'selected' => ($this->content == "configcurrencies.php") ? "selected" : "",
			);
		}
		$leaves['configcompanies.php'] = array(
			'name' => $GLOBALS['txt_companies'],
			'link' => "configcompanies.php",
			'title' => "",
			'selected' => ($this->content == "configcompanies.php") ? "selected" : "",
		);
		$leaves['configparametrizing.php'] = array(
			'name' => $GLOBALS['txt_parametrizing'],
			'link' => "configparametrizing.php",
			'title' => "",
			'selected' => ($this->content == "configparametrizing.php") ? "selected" : "",
		);
		$this->tree['config']['leaves'] = $leaves;
		return $this;
	}
	
	function add_leaves_on_guest() {
		$leaves = array();
		
		if ($this->authenticated->has_access_to("requests")) {
			$leaves['requests.php'] = array(
				'name' => $GLOBALS['param']['requests'],
				'link' => "requests.php",
				'selected' => (preg_match("/^request/", $this->content)) ? "selected" : "",
			);
		}
		if ($this->authenticated->has_access_to("activityreport")) {
			$leaves['selector'] = array(
				'data' => "<div class=\"forms\">".$this->selector_for_user()."</form>",
			);
			$leaves['activityreport.php'] = array(
				'name' => __("activity report"),
				'link' => "activityreport.php",
				'selected' => ($this->content == "activityreport.php") ? "selected" : "",
			);
		}
		if ($this->authenticated->has_access_to("absences")) {
			$leaves['selector'] = array(
				'data' => "<div class=\"forms\">".$this->selector_for_user()."</form>",
			);
			$leaves['absencesynthesis.php'] = array(
				'name' => __("absence synthesis"),
				'link' => "absencesynthesis.php",
				'selected' => ($this->content == "absencesynthesis.php") ? "selected" : "",
			);
			$leaves['absencefeedback.php'] = array(
				'name' => $GLOBALS['param']['feedback'],
				'link' => "absencefeedback.php",
				'selected' => ($this->content == "absencefeedback.php") ? "selected" : "",
			);
		}
		$this->tree['guest']['leaves'] = $leaves;
		return $this;
	}

	function add_missing_links_on_branches() {
		foreach ($this->tree as $key => $branch) {
			if (!isset($branch['link']) or empty($branch['link'])) {
				if (isset($this->tree[$key]['leaves'])) {
					foreach ($this->tree[$key]['leaves'] as $leaf) {
						if (isset($leaf['link'])) {
							$link = $leaf['link'];
							if ($position = strpos($link, "&")) {
								$link = substr($link, 0, $position);
							}
							$this->tree[$key]['link'] = $link;
							break;
						}
					}
				}
			}
		}
	}
	
	function mark_selected_branch() {
		foreach ($this->trunk() as $key => $branch) {
			if (isset($this->tree[$key]['leaves'])) {
				foreach ($this->tree[$key]['leaves'] as $leaf) {
					if (isset($leaf['selected']) and $leaf['selected'] == "selected") {
						$this->tree[$key]['selected'] = "selected";
					}
				}
			}
		}
		return $this;
	}	
}
