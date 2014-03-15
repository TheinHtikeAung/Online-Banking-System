<%@ include file="layout/adminheader.jsp" %>
<%@ include file="layout/adminmenu.jsp" %>			
			
			<div id="content-admin-main">
			
			<h1 id="admin-title"><fmt:message key="admin.customerpanel"/></h1>
			
			<form action="./customerProcess" method=post>
			<table class="center-table">
				<tr>
					<td><fmt:message key="label.customer.nric"/> : </td>
					
					<c:if test="${param['insert']==true}" >
					<td><input type="text" name="nric" value="${param['nric']}" size=15 maxlength=20></td>
					<input type="hidden" name="insert" value="true" />
					</c:if>
					
					<c:if test="${param['update']==true}" >
					<td><input type="text" name="nric" value="${param['nric']}" size=15 maxlength=20 readonly="readonly"></td>
					<input type="hidden" name="insert" value="false" />
					</c:if>

				</tr>
				<tr>
					<td><fmt:message key="label.customer.name"/> : </td>
					<td><input type="text" name="name" value="${param['name']}" size=15 maxlength=20></td>
				</tr>
				<tr>
					<td><fmt:message key="label.customer.address"/> : </td>
					<td><TEXTAREA NAME="address" ROWS=3 COLS=30 >${param['address']}</TEXTAREA></td>
				</tr>
				<tr>
					<td><fmt:message key="label.customer.dob"/> : </td>
					<td><input type="text" name="dateOfBirth" value="${param['dateOfBirth']}" size=15 maxlength=20>
						<fmt:message key="label.customer.format"/>
					</td>
				</tr>
				<tr>
					<td><fmt:message key="label.customer.nationality"/> : </td>
					<%-- <td><input type="text" name="nationality" value="${param['nationality']}" size=15 maxlength=20></td> --%>
					
					<%-- <c:if test="${param['nationality']=='Afghan'}"> selected="selected"</c:if> --%>
					<td>
					<select name="nationality">
					
					  <option value="">-- select one --</option>
					  <option value="Afghan" <c:if test="${param['nationality']=='Afghan'}"> selected="selected"</c:if>>Afghan</option>
					  <option value="Albanian" <c:if test="${param['nationality']=='Albanian'}"> selected="selected"</c:if>>Albanian</option>
					  <option value="Algerian" <c:if test="${param['nationality']=='Algerian'}"> selected="selected"</c:if>>Algerian</option>
					  <option value="American" <c:if test="${param['nationality']=='American'}"> selected="selected"</c:if>>American</option>
					  <option value="Andorran" <c:if test="${param['nationality']=='Andorran'}"> selected="selected"</c:if>>Andorran</option>
					  <option value="Angolan" <c:if test="${param['nationality']=='Angolan'}"> selected="selected"</c:if>>Angolan</option>
					  <option value="Antiguans" <c:if test="${param['nationality']=='Antiguans'}"> selected="selected"</c:if>>Antiguans</option>
					  <option value="Argentinean" <c:if test="${param['nationality']=='Argentinean'}"> selected="selected"</c:if>>Argentinean</option>
					  <option value="Armenian" <c:if test="${param['nationality']=='Armenian'}"> selected="selected"</c:if>>Armenian</option>
					  <option value="Australian" <c:if test="${param['nationality']=='Australian'}"> selected="selected"</c:if>>Australian</option>
					  <option value="Austrian" <c:if test="${param['nationality']=='Austrian'}"> selected="selected"</c:if>>Austrian</option>
					  <option value="Azerbaijani" <c:if test="${param['nationality']=='Azerbaijani'}"> selected="selected"</c:if>>Azerbaijani</option>
					  <option value="Bahamian" <c:if test="${param['nationality']=='Bahamian'}"> selected="selected"</c:if>>Bahamian</option>
					  <option value="Bahraini" <c:if test="${param['nationality']=='Bahraini'}"> selected="selected"</c:if>>Bahraini</option>
					  <option value="Bangladeshi" <c:if test="${param['nationality']=='Bangladeshi'}"> selected="selected"</c:if>>Bangladeshi</option>
					  <option value="Barbadian" <c:if test="${param['nationality']=='Barbadian'}"> selected="selected"</c:if>>Barbadian</option>
					  <option value="Barbudans" <c:if test="${param['nationality']=='Barbudans'}"> selected="selected"</c:if>>Barbudans</option>
					  <option value="Batswana" <c:if test="${param['nationality']=='Batswana'}"> selected="selected"</c:if>>Batswana</option>
					  <option value="Belarusian" <c:if test="${param['nationality']=='Belarusian'}"> selected="selected"</c:if>>Belarusian</option>
					  <option value="Belgian" <c:if test="${param['nationality']=='Belgian'}"> selected="selected"</c:if>>Belgian</option>
					  <option value="Belizean" <c:if test="${param['nationality']=='Belizean'}"> selected="selected"</c:if>>Belizean</option>
					  <option value="Beninese" <c:if test="${param['nationality']=='Beninese'}"> selected="selected"</c:if>>Beninese</option>
					  <option value="Bhutanese" <c:if test="${param['nationality']=='Bhutanese'}"> selected="selected"</c:if>>Bhutanese</option>
					  <option value="Bolivian" <c:if test="${param['nationality']=='Bolivian'}"> selected="selected"</c:if>>Bolivian</option>
					  <option value="Bosnian" <c:if test="${param['nationality']=='Bosnian'}"> selected="selected"</c:if>>Bosnian</option>
					  <option value="Brazilian" <c:if test="${param['nationality']=='Brazilian'}"> selected="selected"</c:if>>Brazilian</option>
					  <option value="British" <c:if test="${param['nationality']=='British'}"> selected="selected"</c:if>>British</option>
					  <option value="Bruneian" <c:if test="${param['nationality']=='Bruneian'}"> selected="selected"</c:if>>Bruneian</option>
					  <option value="Bulgarian" <c:if test="${param['nationality']=='Bulgarian'}"> selected="selected"</c:if>>Bulgarian</option>
					  <option value="Burkinabe" <c:if test="${param['nationality']=='Burkinabe'}"> selected="selected"</c:if>>Burkinabe</option>
					  <option value="Burmese" <c:if test="${param['nationality']=='Burmese'}"> selected="selected"</c:if>>Burmese</option>
					  <option value="Burundian" <c:if test="${param['nationality']=='Burundian'}"> selected="selected"</c:if>>Burundian</option>
					  <option value="Cambodian" <c:if test="${param['nationality']=='Cambodian'}"> selected="selected"</c:if>>Cambodian</option>
					  <option value="Cameroonian" <c:if test="${param['nationality']=='Cameroonian'}"> selected="selected"</c:if>>Cameroonian</option>
					  <option value="Canadian" <c:if test="${param['nationality']=='Canadian'}"> selected="selected"</c:if>>Canadian</option>
					  <option value="Cape verdean" <c:if test="${param['nationality']=='Cape Verdean'}"> selected="selected"</c:if>>Cape Verdean</option>
					  <option value="Central african" <c:if test="${param['nationality']=='Central African'}"> selected="selected"</c:if>>Central African</option>
					  <option value="Chadian" <c:if test="${param['nationality']=='Chadian'}"> selected="selected"</c:if>>Chadian</option>
					  <option value="Chilean" <c:if test="${param['nationality']=='Chilean'}"> selected="selected"</c:if>>Chilean</option>
					  <option value="Chinese" <c:if test="${param['nationality']=='Chinese'}"> selected="selected"</c:if>>Chinese</option>
					  <option value="Colombian" <c:if test="${param['nationality']=='Colombian'}"> selected="selected"</c:if>>Colombian</option>
					  <option value="Comoran" <c:if test="${param['nationality']=='Comoran'}"> selected="selected"</c:if>>Comoran</option>
					  <option value="Congolese" <c:if test="${param['nationality']=='Congolese'}"> selected="selected"</c:if>>Congolese</option>
					  <option value="Costa rican" <c:if test="${param['nationality']=='Costa Rican'}"> selected="selected"</c:if>>Costa Rican</option>
					  <option value="Croatian" <c:if test="${param['nationality']=='Croatian'}"> selected="selected"</c:if>>Croatian</option>
					  <option value="Cuban" <c:if test="${param['nationality']=='Cuban'}"> selected="selected"</c:if>>Cuban</option>
					  <option value="Cypriot" <c:if test="${param['nationality']=='Cypriot'}"> selected="selected"</c:if>>Cypriot</option>
					  <option value="Czech" <c:if test="${param['nationality']=='Czech'}"> selected="selected"</c:if>>Czech</option>
					  <option value="Danish" <c:if test="${param['nationality']=='Danish'}"> selected="selected"</c:if>>Danish</option>					  
					  <option value="Djibouti" <c:if test="${param['nationality']=='Djibouti'}"> selected="selected"</c:if>>Djibouti</option>
					  <option value="Dominican" <c:if test="${param['nationality']=='Dominican'}"> selected="selected"</c:if>>Dominican</option>
					  <option value="Dutch" <c:if test="${param['nationality']=='Dutch'}"> selected="selected"</c:if>>Dutch</option>
					  <option value="East Timorese" <c:if test="${param['nationality']=='East Timorese'}"> selected="selected"</c:if>>East Timorese</option>
					  <option value="Ecuadorean" <c:if test="${param['nationality']=='Ecuadorean'}"> selected="selected"</c:if>>Ecuadorean</option>
					  <option value="Egyptian" <c:if test="${param['nationality']=='Egyptian'}"> selected="selected"</c:if>>Egyptian</option>
					  <option value="Emirian" <c:if test="${param['nationality']=='Emirian'}"> selected="selected"</c:if>>Emirian</option>
					  <option value="Equatorial Guinean" <c:if test="${param['nationality']=='Equatorial Guinean'}"> selected="selected"</c:if>>Equatorial Guinean</option>
					  <option value="Eritrean" <c:if test="${param['nationality']=='Eritrean'}"> selected="selected"</c:if>>Eritrean</option>
					  <option value="Estonian" <c:if test="${param['nationality']=='Estonian'}"> selected="selected"</c:if>>Estonian</option>
					  <option value="Ethiopian" <c:if test="${param['nationality']=='Ethiopian'}"> selected="selected"</c:if>>Ethiopian</option>
					  <option value="Fijian" <c:if test="${param['nationality']=='Fijian'}"> selected="selected"</c:if>>Fijian</option>
					  <option value="Filipino" <c:if test="${param['nationality']=='Filipino'}"> selected="selected"</c:if>>Filipino</option>
					  <option value="Finnish" <c:if test="${param['nationality']=='Finnish'}"> selected="selected"</c:if>>Finnish</option>
					  <option value="French" <c:if test="${param['nationality']=='French'}"> selected="selected"</c:if>>French</option>
					  <option value="Gabonese" <c:if test="${param['nationality']=='Gabonese'}"> selected="selected"</c:if>>Gabonese</option>
					  <option value="Gambian" <c:if test="${param['nationality']=='Gambian'}"> selected="selected"</c:if>>Gambian</option>
					  <option value="Georgian" <c:if test="${param['nationality']=='Georgian'}"> selected="selected"</c:if>>Georgian</option>
					  <option value="German" <c:if test="${param['nationality']=='German'}"> selected="selected"</c:if>>German</option>
					  <option value="Ghanaian" <c:if test="${param['nationality']=='Ghanaian'}"> selected="selected"</c:if>>Ghanaian</option>
					  <option value="Greek" <c:if test="${param['nationality']=='Greek'}"> selected="selected"</c:if>>Greek</option>
					  <option value="Grenadian" <c:if test="${param['nationality']=='Grenadian'}"> selected="selected"</c:if>>Grenadian</option>
					  <option value="Guatemalan" <c:if test="${param['nationality']=='Guatemalan'}"> selected="selected"</c:if>>Guatemalan</option>
					  <option value="Guinea-Bissauan" <c:if test="${param['nationality']=='Guinea-Bissauan'}"> selected="selected"</c:if>>Guinea-Bissauan</option>
					  <option value="Guinean" <c:if test="${param['nationality']=='Guinean'}"> selected="selected"</c:if>>Guinean</option>
					  <option value="Guyanese" <c:if test="${param['nationality']=='Guyanese'}"> selected="selected"</c:if>>Guyanese</option>
					  <option value="Haitian" <c:if test="${param['nationality']=='Haitian'}"> selected="selected"</c:if>>Haitian</option>
					  <option value="Herzegovinian" <c:if test="${param['nationality']=='Herzegovinian'}"> selected="selected"</c:if>>Herzegovinian</option>
					  <option value="Honduran" <c:if test="${param['nationality']=='Honduran'}"> selected="selected"</c:if>>Honduran</option>
					  <option value="Hungarian" <c:if test="${param['nationality']=='Hungarian'}"> selected="selected"</c:if>>Hungarian</option>
					  <option value="Icelander" <c:if test="${param['nationality']=='Icelander'}"> selected="selected"</c:if>>Icelander</option>
					  <option value="Indian" <c:if test="${param['nationality']=='Indian'}"> selected="selected"</c:if>>Indian</option>
					  <option value="Indonesian" <c:if test="${param['nationality']=='Indonesian'}"> selected="selected"</c:if>>Indonesian</option>
					  <option value="Iranian" <c:if test="${param['nationality']=='Iranian'}"> selected="selected"</c:if>>Iranian</option>
					  <option value="Iraqi" <c:if test="${param['nationality']=='Iraqi'}"> selected="selected"</c:if>>Iraqi</option>
					  <option value="Irish" <c:if test="${param['nationality']=='Irish'}"> selected="selected"</c:if>>Irish</option>
					  <option value="Israeli" <c:if test="${param['nationality']=='Israeli'}"> selected="selected"</c:if>>Israeli</option>
					  <option value="Italian" <c:if test="${param['nationality']=='Italian'}"> selected="selected"</c:if>>Italian</option>
					  <option value="Ivorian" <c:if test="${param['nationality']=='Ivorian'}"> selected="selected"</c:if>>Ivorian</option>
					  <option value="Jamaican" <c:if test="${param['nationality']=='Jamaican'}"> selected="selected"</c:if>>Jamaican</option>
					  <option value="Japanese" <c:if test="${param['nationality']=='Japanese'}"> selected="selected"</c:if>>Japanese</option>
					  <option value="Jordanian" <c:if test="${param['nationality']=='Jordanian'}"> selected="selected"</c:if>>Jordanian</option>
					  <option value="Kazakhstani" <c:if test="${param['nationality']=='Kazakhstani'}"> selected="selected"</c:if>>Kazakhstani</option>
					  <option value="Kenyan" <c:if test="${param['nationality']=='Kenyan'}"> selected="selected"</c:if>>Kenyan</option>
					  <option value="Kittian And Nevisian" <c:if test="${param['nationality']=='Kittian And Nevisian'}"> selected="selected"</c:if>>Kittian And Nevisian</option>
					  <option value="Kuwaiti" <c:if test="${param['nationality']=='Kuwaiti'}"> selected="selected"</c:if>>Kuwaiti</option>
					  <option value="Kyrgyz" <c:if test="${param['nationality']=='Kyrgyz'}"> selected="selected"</c:if>>Kyrgyz</option>
					  <option value="Laotian" <c:if test="${param['nationality']=='Laotian'}"> selected="selected"</c:if>>Laotian</option>
					  <option value="Latvian" <c:if test="${param['nationality']=='Latvian'}"> selected="selected"</c:if>>Latvian</option>
					  <option value="Lebanese" <c:if test="${param['nationality']=='Lebanese'}"> selected="selected"</c:if>>Lebanese</option>
					  <option value="Liberian" <c:if test="${param['nationality']=='Liberian'}"> selected="selected"</c:if>>Liberian</option>
					  <option value="Libyan" <c:if test="${param['nationality']=='Libyan'}"> selected="selected"</c:if>>Libyan</option>
					  <option value="Liechtensteiner" <c:if test="${param['nationality']=='Liechtensteiner'}"> selected="selected"</c:if>>Liechtensteiner</option>
					  <option value="Lithuanian" <c:if test="${param['nationality']=='Lithuanian'}"> selected="selected"</c:if>>Lithuanian</option>
					  <option value="Luxembourger" <c:if test="${param['nationality']=='Luxembourger'}"> selected="selected"</c:if>>Luxembourger</option>
					  <option value="Macedonian" <c:if test="${param['nationality']=='Macedonian'}"> selected="selected"</c:if>>Macedonian</option>
					  <option value="Malagasy" <c:if test="${param['nationality']=='Malagasy'}"> selected="selected"</c:if>>Malagasy</option>
					  <option value="Malawian" <c:if test="${param['nationality']=='Malawian'}"> selected="selected"</c:if>>Malawian</option>
					  <option value="Malaysian" <c:if test="${param['nationality']=='Malaysian'}"> selected="selected"</c:if>>Malaysian</option>
					  <option value="Maldivan" <c:if test="${param['nationality']=='Maldivan'}"> selected="selected"</c:if>>Maldivan</option>
					  <option value="Malian" <c:if test="${param['nationality']=='Malian'}"> selected="selected"</c:if>>Malian</option>
					  <option value="Maltese" <c:if test="${param['nationality']=='Maltese'}"> selected="selected"</c:if>>Maltese</option>
					  <option value="Marshallese" <c:if test="${param['nationality']=='Marshallese'}"> selected="selected"</c:if>>Marshallese</option>
					  <option value="Mauritanian" <c:if test="${param['nationality']=='Mauritanian'}"> selected="selected"</c:if>>Mauritanian</option>
					  <option value="Mauritian" <c:if test="${param['nationality']=='Mauritian'}"> selected="selected"</c:if>>Mauritian</option>
					  <option value="Mexican" <c:if test="${param['nationality']=='Mexican'}"> selected="selected"</c:if>>Mexican</option>
					  <option value="Micronesian" <c:if test="${param['nationality']=='Micronesian'}"> selected="selected"</c:if>>Micronesian</option>
					  <option value="Moldovan" <c:if test="${param['nationality']=='Moldovan'}"> selected="selected"</c:if>>Moldovan</option>
					  <option value="Monacan" <c:if test="${param['nationality']=='Monacan'}"> selected="selected"</c:if>>Monacan</option>
					  <option value="Mongolian" <c:if test="${param['nationality']=='Mongolian'}"> selected="selected"</c:if>>Mongolian</option>
					  <option value="Moroccan" <c:if test="${param['nationality']=='Moroccan'}"> selected="selected"</c:if>>Moroccan</option>
					  <option value="Mosotho" <c:if test="${param['nationality']=='Mosotho'}"> selected="selected"</c:if>>Mosotho</option>
					  <option value="Motswana" <c:if test="${param['nationality']=='Motswana'}"> selected="selected"</c:if>>Motswana</option>
					  <option value="Mozambican" <c:if test="${param['nationality']=='Mozambican'}"> selected="selected"</c:if>>Mozambican</option>
					  <option value="Namibian" <c:if test="${param['nationality']=='Namibian'}"> selected="selected"</c:if>>Namibian</option>
					  <option value="Nauruan" <c:if test="${param['nationality']=='Nauruan'}"> selected="selected"</c:if>>Nauruan</option>
					  <option value="Nepalese" <c:if test="${param['nationality']=='Nepalese'}"> selected="selected"</c:if>>Nepalese</option>
					  <option value="New Zealander" <c:if test="${param['nationality']=='New Zealander'}"> selected="selected"</c:if>>New Zealander</option>
					  <option value="Ni-Vanuatu" <c:if test="${param['nationality']=='Ni-Vanuatu'}"> selected="selected"</c:if>>Ni-Vanuatu</option>
					  <option value="Nicaraguan" <c:if test="${param['nationality']=='Nicaraguan'}"> selected="selected"</c:if>>Nicaraguan</option>
					  <option value="Nigerien" <c:if test="${param['nationality']=='Nigerien'}"> selected="selected"</c:if>>Nigerien</option>
					  <option value="North Korean" <c:if test="${param['nationality']=='North Korean'}"> selected="selected"</c:if>>North Korean</option>
					  <option value="Northern Irish" <c:if test="${param['nationality']=='Northern Irish'}"> selected="selected"</c:if>>Northern Irish</option>
					  <option value="Norwegian" <c:if test="${param['nationality']=='Norwegian'}"> selected="selected"</c:if>>Norwegian</option>
					  <option value="Omani" <c:if test="${param['nationality']=='Omani'}"> selected="selected"</c:if>>Omani</option>
					  <option value="Pakistani" <c:if test="${param['nationality']=='Pakistani'}"> selected="selected"</c:if>>Pakistani</option>
					  <option value="Palauan" <c:if test="${param['nationality']=='Palauan'}"> selected="selected"</c:if>>Palauan</option>
					  <option value="Panamanian" <c:if test="${param['nationality']=='Panamanian'}"> selected="selected"</c:if>>Panamanian</option>
					  <option value="Papua New Guinean" <c:if test="${param['nationality']=='Papua New Guinean'}"> selected="selected"</c:if>>Papua New Guinean</option>
					  <option value="Paraguayan" <c:if test="${param['nationality']=='Paraguayan'}"> selected="selected"</c:if>>Paraguayan</option>
					  <option value="Peruvian" <c:if test="${param['nationality']=='Peruvian'}"> selected="selected"</c:if>>Peruvian</option>
					  <option value="Polish" <c:if test="${param['nationality']=='Polish'}"> selected="selected"</c:if>>Polish</option>
					  <option value="Portuguese" <c:if test="${param['nationality']=='Portuguese'}"> selected="selected"</c:if>>Portuguese</option>
					  <option value="Qatari" <c:if test="${param['nationality']=='Qatari'}"> selected="selected"</c:if>>Qatari</option>
					  <option value="Romanian" <c:if test="${param['nationality']=='Romanian'}"> selected="selected"</c:if>>Romanian</option>
					  <option value="Russian" <c:if test="${param['nationality']=='Russian'}"> selected="selected"</c:if>>Russian</option>
					  <option value="Rwandan" <c:if test="${param['nationality']=='Rwandan'}"> selected="selected"</c:if>>Rwandan</option>
					  <option value="Saint Lucian" <c:if test="${param['nationality']=='Saint Lucian'}"> selected="selected"</c:if>>Saint Lucian</option>
					  <option value="Salvadoran" <c:if test="${param['nationality']=='Salvadoran'}"> selected="selected"</c:if>>Salvadoran</option>
					  <option value="Samoan" <c:if test="${param['nationality']=='Samoan'}"> selected="selected"</c:if>>Samoan</option>
					  <option value="San Marinese" <c:if test="${param['nationality']=='San Marinese'}"> selected="selected"</c:if>>San Marinese</option>
					  <option value="Sao Tomean" <c:if test="${param['nationality']=='Sao Tomean'}"> selected="selected"</c:if>>Sao Tomean</option>
					  <option value="Saudi" <c:if test="${param['nationality']=='Saudi'}"> selected="selected"</c:if>>Saudi</option>
					  <option value="Scottish" <c:if test="${param['nationality']=='Scottish'}"> selected="selected"</c:if>>Scottish</option>
					  <option value="Senegalese" <c:if test="${param['nationality']=='Senegalese'}"> selected="selected"</c:if>>Senegalese</option>
					  <option value="Serbian" <c:if test="${param['nationality']=='Serbian'}"> selected="selected"</c:if>>Serbian</option>
					  <option value="Seychellois" <c:if test="${param['nationality']=='Seychellois'}"> selected="selected"</c:if>>Seychellois</option>
					  <option value="Sierra Leonean" <c:if test="${param['nationality']=='Sierra Leonean'}"> selected="selected"</c:if>>Sierra Leonean</option>
					  <option value="Singaporean" <c:if test="${param['nationality']=='Singaporean'}"> selected="selected"</c:if>>Singaporean</option>
					  <option value="Slovakian" <c:if test="${param['nationality']=='Slovakian'}"> selected="selected"</c:if>>Slovakian</option>
					  <option value="Slovenian" <c:if test="${param['nationality']=='Slovenian'}"> selected="selected"</c:if>>Slovenian</option>
					  <option value="Solomon Islander" <c:if test="${param['nationality']=='Solomon Islander'}"> selected="selected"</c:if>>Solomon Islander</option>
					  <option value="Somali" <c:if test="${param['nationality']=='Somali'}"> selected="selected"</c:if>>Somali</option>
					  <option value="South African" <c:if test="${param['nationality']=='South African'}"> selected="selected"</c:if>>South African</option>
					  <option value="South Korean" <c:if test="${param['nationality']=='South Korean'}"> selected="selected"</c:if>>South Korean</option>
					  <option value="Spanish" <c:if test="${param['nationality']=='Spanish'}"> selected="selected"</c:if>>Spanish</option>
					  <option value="Sri Lankan" <c:if test="${param['nationality']=='Sri Lankan'}"> selected="selected"</c:if>>Sri Lankan</option>
					  <option value="Sudanese" <c:if test="${param['nationality']=='Sudanese'}"> selected="selected"</c:if>>Sudanese</option>
					  <option value="Surinamer" <c:if test="${param['nationality']=='Surinamer'}"> selected="selected"</c:if>>Surinamer</option>
					  <option value="Swazi" <c:if test="${param['nationality']=='Swazi'}"> selected="selected"</c:if>>Swazi</option>
					  <option value="Swedish" <c:if test="${param['nationality']=='Swedish'}"> selected="selected"</c:if>>Swedish</option>
					  <option value="Swiss" <c:if test="${param['nationality']=='Swiss'}"> selected="selected"</c:if>>Swiss</option>
					  <option value="Syrian" <c:if test="${param['nationality']=='Syrian'}"> selected="selected"</c:if>>Syrian</option>
					  <option value="Taiwanese" <c:if test="${param['nationality']=='Taiwanese'}"> selected="selected"</c:if>>Taiwanese</option>
					  <option value="Tajik" <c:if test="${param['nationality']=='Tajik'}"> selected="selected"</c:if>>Tajik</option>
					  <option value="Tanzanian" <c:if test="${param['nationality']=='Tanzanian'}"> selected="selected"</c:if>>Tanzanian</option>
					  <option value="Thai" <c:if test="${param['nationality']=='Thai'}"> selected="selected"</c:if>>Thai</option>
					  <option value="Togolese" <c:if test="${param['nationality']=='Togolese'}"> selected="selected"</c:if>>Togolese</option>
					  <option value="Tongan" <c:if test="${param['nationality']=='Tongan'}"> selected="selected"</c:if>>Tongan</option>
					  <option value="Trinidadian Or Tobagonian" <c:if test="${param['nationality']=='Trinidadian Or Tobagonian'}"> selected="selected"</c:if>>Trinidadian or Tobagonian</option>
					  <option value="Tunisian" <c:if test="${param['nationality']=='Tunisian'}"> selected="selected"</c:if>>Tunisian</option>
					  <option value="Turkish" <c:if test="${param['nationality']=='Turkish'}"> selected="selected"</c:if>>Turkish</option>
					  <option value="Tuvaluan"<c:if test="${param['nationality']=='Tuvaluan'}"> selected="selected"</c:if>>Tuvaluan</option>
					  <option value="Ugandan" <c:if test="${param['nationality']=='Ugandan'}"> selected="selected"</c:if>>Ugandan</option>
					  <option value="Ukrainian" <c:if test="${param['nationality']=='Ukrainian'}"> selected="selected"</c:if>>Ukrainian</option>
					  <option value="Uruguayan" <c:if test="${param['nationality']=='Uruguayan'}"> selected="selected"</c:if>>Uruguayan</option>
					  <option value="Uzbekistani" <c:if test="${param['nationality']=='Uzbekistani'}"> selected="selected"</c:if>>Uzbekistani</option>
					  <option value="Venezuelan" <c:if test="${param['nationality']=='Venezuelan'}"> selected="selected"</c:if>>Venezuelan</option>
					  <option value="Vietnamese" <c:if test="${param['nationality']=='Vietnamese'}"> selected="selected"</c:if>>Vietnamese</option>
					  <option value="Welsh" <c:if test="${param['nationality']=='Welsh'}"> selected="selected"</c:if>>Welsh</option>
					  <option value="Yemenite" <c:if test="${param['nationality']=='Yemenite'}"> selected="selected"</c:if>>Yemenite</option>
					  <option value="Zambian" <c:if test="${param['nationality']=='Zambian'}"> selected="selected"</c:if>>Zambian</option>
					  <option value="Zimbabwean" <c:if test="${param['nationality']=='Zimbabwean'}"> selected="selected"</c:if>>Zimbabwean</option> 
					</select>
					</td>
				</tr>
				
				<tr>
					<td><fmt:message key="label.customer.gender"/> : </td>
					<td>
					
					<c:if test="${param['gender']==null}" >
						<input name="gender" type="radio" value="Male" checked="checked"/> Male
						<input name="gender" type="radio" value="Female" /> Female
					</c:if>
				
					<c:if test="${param['gender']!=null}" >				
						<input name="gender" type="radio" value="Male" <c:if test="${param['gender']=='Male'}">checked="checked"</c:if>/> Male
						<input name="gender" type="radio" value="Female" <c:if test="${param['gender']=='Female'}" >checked="checked"</c:if>/> Female
					</c:if>

						
					</td>
				</tr>
				<tr>	
					<td><fmt:message key="label.customer.userid"/> : </td>
					<td><input type="text" name="userid" value="${param['userid']}" size=15 maxlength=20></td>
				</tr>
				<tr>	
					<td><fmt:message key="label.customer.password"/> : </td>
					<td><input type="password" name="password" value="${param['password']}" size=15 maxlength=20></td>
				</tr>
				<tr>	
					<td><fmt:message key="label.customer.join"/> : </td>
					<td><input type="text" name="dateOfJoining" value="${param['dateOfJoining']}" size=15 maxlength=20>
						<fmt:message key="label.customer.format"/>
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input class="button grey" type="submit" value="Submit"> 
						<input class="button grey" type="reset"  value="Reset">
					</td>
				</tr>
				
			</table>
			</form>
			
			</div>

			</div>
			
		
		
<%@ include file="layout/footer.jsp" %>