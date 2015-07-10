unit Unit2;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, PLanner;

type
  TForm2 = class(TCustomItemEditor)
  private
    { Private declarations }
  public
    function QueryEdit(APlannerItem: TPlannerItem): Boolean;
    { Public declarations }
  end;

var
  DefaultItemEditor1: TForm2;

implementation

{$R *.dfm}

{ TForm2 }

function TForm2.QueryEdit(APlannerItem: TPlannerItem): Boolean;
begin
  showmessage('');
end;

end.
 