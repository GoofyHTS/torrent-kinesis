/*
The MIT License (MIT)
Copyright (c) 2015 GoofyHTS
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package goofyhts.torrentkinesis.torrent.server.setting.entry;

/**
 * Defines a server setting entry
 * @author GoofyHTS
 *
 */
public interface TorrentServerSettingEntry {

	/**
	 * Gets the name of the setting
	 * @return Name of the setting
	 */
	String getName();
	
	/**
	 * Gets the value of the setting
	 * @return Value of the setting
	 */
	String getValue();
	
	/**
	 * Sets the value of the setting
	 * @param value The new value of the setting
	 */
	void setValue(String value);
	
	/**
	 * Saves the setting to the server.
	 * <p>
	 * This results in a single request being sent to the server
	 */
	void save();
}
