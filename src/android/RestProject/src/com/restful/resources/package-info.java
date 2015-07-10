// every java.util.Date class in the com.restful.resources package should be
// processed by DateAdapter
@XmlJavaTypeAdapter(value=DateAdapter.class, type=Date.class)
package com.restful.resources;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;


