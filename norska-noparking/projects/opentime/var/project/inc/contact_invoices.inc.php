<?php
/*
	opentime
	$Author: $
	$URL: $
	$Revision: $

	Copyright (C) No Parking 2011 - 2018
*/

class Contact_Invoices extends Invoices {
	public $contact_id;

	function __construct($contact_id = 0) {
		parent::__construct();
		$this->contact_id = (int)$contact_id;
	}
	
	function show() {
		$html = "";
		
		if (count($this) > 0) {
			$html .= $GLOBALS['txt_invoices'].":&nbsp;<br />";
			
			$items = array();
			foreach ($this as $invoice) {
				$items[] = array(
					'value' => Html_Tag::a(link_content("content=invoice.php&invoice_id=".$invoice->id), $invoice->number." - ".$invoice->title),
				);
			}
			
			$list = new Html_List($items);
			$html .= $list->show();
		}

		return $html;
	}
}
